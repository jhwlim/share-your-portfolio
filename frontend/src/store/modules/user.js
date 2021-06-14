import AuthApi from '@/api/AuthApi.js';
import AuthUtil from '@/util/AuthUtil.js';

const state = {
    uid: '',
    username: '',
    exp: 0,
    isLogined: '',
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
    initUserInfo(state) {
        const token = AuthUtil.getToken();
        if (token) {
            const userInfo = AuthUtil.getUserInfo(token);
            this.commit('setUserInfo', userInfo);
        }

        console.log(state); 
    }
}

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
    logout(context) {
        return AuthApi.logout()
                    .then(() => {
                        AuthUtil.removeToken();
                    })
                    .catch((error) => {
                        console.log(error);
                    })
                    .finally(() => {
                        context.commit('clearUserInfo');
                    });
    }
};

export default {
    state,
    getters,
    mutations,
    actions,
}