<template>
    <div class="account-image">
        <div class="account-image__image-box" 
            @mouseenter="showBtn = true"
            @mouseleave="showBtn = false">
            <user-image 
                :id="getUid"
                class="account-image__image"></user-image>
            <div 
                v-if="showBtn"
                class="account-image__hide">
                <button 
                    @click="uploadImage()"
                    class="pointer">수정</button>
                <button 
                    @click="deleteImage()"
                    class="pointer">삭제</button>
            </div>
        </div>
        
        <span>{{ getUsername }}</span>
    </div>
</template>

<script>
import UserImage from '@/components/common/UserImage.vue';
import { mapGetters } from 'vuex';

export default {
    data: function() {
        return {
            showBtn: false,
        };
    },
    components: {
        UserImage,
    },
    computed: {
        ...mapGetters([
            'getUid',
            'getUsername'
        ]),
    },
    methods: {
        uploadImage() {
            console.log('Upload!')
        },
        deleteImage() {
            console.log('Delete!');
        },
    }
}
</script>

<style scoped>
.account-image {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
}
.account-image span {
    font-size: 26px;
    font-weight: 500;
}
.account-image__image-box {
    position: relative;
    width: 120px;
    height: 120px;
}
.account-image__image {
    width: 100%;
    height: 100%;
    margin: 0 auto 10px;
}
.account-image__hide {
    display: inline-block;
    width: 120px;
    height: 120px;
    position: absolute;
    top: 0;
    left: 0;
    background: #00000086;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
    padding: 25px 20px;
    box-sizing: border-box;
    border-radius: 10px;
}
.account-image__hide button {
    width: 60px;
    border: 2px solid #ffffff;
    border-radius: 5px;
    background: transparent;
    color: #ffffff;
}
.account-image__hide button:hover{
    background: #ffffff;
    color: #000;
}
</style>