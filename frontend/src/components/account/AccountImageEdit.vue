<template>
    <div class="account-image">
        <div class="account-image__image-box" 
            @mouseenter="showBtn = true"
            @mouseleave="showBtn = false">
            <user-image 
                :id="getUid"
                :isLoading="isLoading"
                class="account-image__image"></user-image>
            <div 
                v-if="showBtn && !isLoading"
                class="account-image__hide">
                <button @click="$refs.file.click()" class="pointer">
                    수정
                    <input 
                        type="file" 
                        ref="file" 
                        @change="uploadImage($event)" 
                        accept="image/png">
                </button>
                <button 
                    @click="deleteImage()"
                    class="pointer">삭제</button>
            </div>
        </div>
        <span>{{ getUsername }}</span>
        <image-crop-modal 
            ref="cropModal"
            v-show="showModal"
            @showModal="showModal = true"
            @closeModal="closeModal()"
            @loading="loading()"
            @complete="complete()"></image-crop-modal>
    </div>
</template>

<script>
import UserImage from '@/components/common/UserImage.vue';
import ImageCropModal from './AccountImageCropModal.vue';
import { mapGetters } from 'vuex';

export default {
    components: {
        UserImage,
        ImageCropModal,
    },
    data: function() {
        return {
            showBtn: false,
            showModal: false,
            isLoading: false,
        };
    },
    computed: {
        ...mapGetters([
            'getUid',
            'getUsername'
        ]),
    },
    methods: {
        loading() {
            this.isLoading = true;
        },
        complete() {
            this.isLoading = false;
        },
        uploadImage(event) {
            const { files } = event.target;
            if (files && files[0]) {
                this.$refs.cropModal.loadImage(files);
            }
        },
        deleteImage() {
            console.log('Delete!');
        },
        closeModal() {
            this.showModal = false;
            this.files = null;
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
.account-image__hide input {
    display: none;
}
</style>