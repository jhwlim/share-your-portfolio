import jwt_decode from 'jwt-decode'

const saveToken = (token) => {
    localStorage.setItem('token', token);
}

const getToken = () => {
    return localStorage.getItem('token');
}

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
}

export default {
    saveToken,
    getToken,
    getUserInfo,
}