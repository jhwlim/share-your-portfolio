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
        state.uid = payload.id;
        state.username = payload.username;
        state.exp = payload.exp;
        state.isLogined = true;
    },
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
};

export default {
    state,
    getters,
    mutations,
    actions,
}