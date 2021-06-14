import jwt_decode from 'jwt-decode'

const tokenName = 'token';
const tokenPrefix = process.env.VUE_APP_JWT_PREFIX + ' ';
    
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
    token = token.replace(tokenPrefix, '');
    
    try {
        let user = jwt_decode(token);
        const exp = user.exp;
        if (Date.now() < exp * 1000) {
            return user;
        }
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