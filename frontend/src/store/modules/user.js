import AuthApi from '@/api/AuthApi.js';
import AuthUtil from '@/util/AuthUtil.js';

const state = {
    uid: '',
    username: '',
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
            state.isLogined = true;    
        } else {
            this.commit('clearUserInfo');
        }
    },
    clearUserInfo(state) {
        state.uid = '';
        state.username = '';
        state.isLogined = false;
    },
};

const actions = {
    async login(context, {username, password}) {
        return await AuthApi.login({username, password})
                            .then((token) => {
                                const userInfo = AuthUtil.getUserInfo(token);
                                context.commit('setUserInfo', userInfo);
                            });
    },
    async logout(context) {
        await AuthApi.logout();
        context.commit('clearUserInfo');
    },
    async refresh(context) {
        const token = await AuthApi.refreshToken();
        console.log(token);
        if (token !== null) {
            console.log('here!');
            const userInfo = AuthUtil.getUserInfo(token);
            context.commit('setUserInfo', userInfo);
        } else {
            context.commit('clearUserInfo');
        }
    },
    async init(context) {
        const token = AuthUtil.getToken();
        if (token === null) {
            return;
        }

        let userInfo = AuthUtil.getUserInfo(token);
        if (userInfo !== null) {
            context.commit('setUserInfo', userInfo);
            return;
        }
        
        await this.dispatch('refresh');
    },
};

export default {
    state,
    getters,
    mutations,
    actions,
}