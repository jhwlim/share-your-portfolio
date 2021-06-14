import AuthApi from '@/api/AuthApi.js';
import AuthUtil from '@/util/AuthUtil.js';


const state = {
    uid: '',
    username: '',
    exp: 0,
    isLogined: false,
};

const getters = {
    getUid(state) {
        return state.uid;
    },
    getUsername(state) {
        return state.username;
    },
    isLogined(state) {
        return state.isLogined;
    }
}

const mutations = {
    setUserInfo(state, payload) {
        if (payload) {
            state.uid = payload.id;
            state.username = payload.username;
            state.exp = payload.exp;
            state.isLogined = true;    
        } else {
            this.commit('clearUserInfo');
        }
    },
    clearUserInfo(state) {
        state.uid = '';
        state.username = '';
        state.exp = '';
        state.isLogined = false;
    },
};

const actions = {
    login(context, {username, password}) {
        return AuthApi.login({username, password})
                    .then((response) => {
                        const token = response.data.token;
                        AuthUtil.saveToken(token);

                        const userInfo = AuthUtil.getUserInfo(token);
                        context.commit('setUserInfo', userInfo);
                    });
    },
    async logout(context) {
        await AuthApi.logout();

        AuthUtil.removeToken();
        context.commit('clearUserInfo');
    },
    async refresh(context) {
        const token = await AuthApi.refreshToken();
        
        if (token !== null) {
            AuthUtil.saveToken(token);
            const userInfo = AuthUtil.getUserInfo(token);
            context.commit('setUserInfo', userInfo);
            console.log('refresh OK');
        } else {
            AuthUtil.removeToken();
            console.log('refresh fail');
        }
    },
    init(context) {
        console.log('init!');
        const token = AuthUtil.getToken();
        if (token === null) {
            return;
        }

        let userInfo = AuthUtil.getUserInfo(token);
        if (userInfo !== null) {
            context.commit('setUserInfo', userInfo);
            return;
        }
        
        this.dispatch('refresh');
    },
};

export default {
    state,
    getters,
    mutations,
    actions,
}