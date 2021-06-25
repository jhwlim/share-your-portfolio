import axios from 'axios';

const upload = async (form) => {
    const url = '/account/image';
    const header = {
        'Content-Type': 'multipart/form-data'
    };
    return await axios.post(url, form, header);
};

export default {
    upload,
}