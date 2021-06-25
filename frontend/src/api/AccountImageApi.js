import axios from 'axios';

const url = '/account/image';
    
const upload = async (form) => {
    const header = {
        'Content-Type': 'multipart/form-data'
    };
    return await axios.post(url, form, header);
};

const remove = async () => {
    return await axios.delete(url);
};

export default {
    upload,
    remove,
};