import axios from 'axios';

const api = axios.create({
    baseURL: '/api',
    headers: {
        'Content-Type': 'application/json',
    }
});

const login = ({username , password}) => {
    const url = '/login';
    const data = {
        username,
        password,
    };
    return api.post(url, data);
};

export default {
    login,
}