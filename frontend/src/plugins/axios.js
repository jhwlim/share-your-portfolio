import axios from 'axios';
import AuthUtil from '@/util/AuthUtil.js';
import store from '@/store';

const tokenHeader = process.env.VUE_APP_JWT_HEADER;

axios.defaults.baseURL = '/api';
axios.defaults.headers['Content-Type'] = 'application/json';

axios.interceptors.request.use(config => {
    const token = AuthUtil.getToken();
    if (token) {
        config.headers[tokenHeader] = token;
    }
    return config;
});

axios.interceptors.response.use(response => response, async error => {
    const token = AuthUtil.getToken();
    const url = error.config.url;
    if (token !== null && url !== '/auth/refresh' && error.response.status === 401) {
        await store.dispatch('refresh');
        const newToken = AuthUtil.getToken();
        if (newToken !== null) {
            error.config.headers[tokenHeader] = newToken;
            console.log('retry!');
            return axios.request(error.config);
        }
    } 

    return Promise.reject(error);
});