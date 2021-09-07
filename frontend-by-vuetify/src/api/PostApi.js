import axios from 'axios';

const savePost = ({ title, content, category, file, writerId }) => {
    const config = {
        headers: {
            'Content-Type': 'multipart/form-data',
        }
    }

    const formData = new FormData();
    formData.append('title', title);
    formData.append('content', content);
    formData.append('category', category);
    formData.append('file', file);
    formData.append('writerId', writerId);

    return axios.post('/post/uploadFile', formData, config);
}

export default {
    savePost,
}