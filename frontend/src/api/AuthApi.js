import axios from 'axios';

const login = ({username , password}) => {
    const url = '/login';
    const data = {
        username,
        password,
    };
    return axios.post(url, data);
};

const logout = async () => {
    const url = '/auth/logout';
    await axios.post(url);
};

const refreshToken = async () => {
    const url = '/auth/refresh';
    const token = await axios.get(url)
                            .then(response => response.data.token)
                            .catch(() => null);
    return token;
};

export default {
    login,
    logout,
    refreshToken,
};