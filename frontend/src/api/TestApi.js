import axios from 'axios';

const test = () => {
    return axios.get('/api');
};

const test1 = () => {
    console.log('test1!');
};

const test2 = () => {
    console.log('test2!');
};

export default {
    test,
    test1,
    test2,
};