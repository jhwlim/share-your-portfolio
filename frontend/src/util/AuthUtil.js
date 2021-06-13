import jwt_decode from 'jwt-decode'

const tokenName = 'token';

const saveToken = (token) => {
    localStorage.setItem(tokenName, token);
};

const getToken = () => {
    return localStorage.getItem(tokenName);
};

const removeToken = () => {
    localStorage.removeItem(tokenName);
};

const getUserInfo = (token) => {
    const tokenPrefix = process.env.VUE_APP_JWT_PREFIX + ' ';
    token = token.replace(tokenPrefix, '');
    
    try {
        let user = jwt_decode(token);
        return user;
    } catch(error) {
        console.log(error);
    }
    return null;
};

export default {
    saveToken,
    getToken,
    getUserInfo,
    removeToken,
};