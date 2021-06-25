<template>
    <common-modal>
        <div slot="header" class="modal__header">
            <h2>Crop your profile picture</h2>
            <span @click="closeModal()" class="material-icons modal__close-btn">close</span>
        </div>
        <div slot="body" class="modal__body">
            <cropper
                :src="image.src"
                :stencil-component="$options.components.CircleStencil"
                :stencil-props="{ aspectRatio: 1/1 }"
                @change="change"
                class="cropper"
            ></cropper>
        </div>
        <div slot="footer" class="modal__footer">
            <button @click="uploadImage()">Upload Image</button>
        </div>
    </common-modal>
</template>

<script>
/* eslint-disable*/
import CommonModal from '@/components/common/CommonModal.vue';
import { Cropper, CircleStencil } from 'vue-advanced-cropper';
import 'vue-advanced-cropper/dist/style.css';
import api from '@/api/AccountImageApi.js';

function getMimeType(file, fallback = null) {
	const byteArray = (new Uint8Array(file)).subarray(0, 4);
    let header = '';
    for (let i = 0; i < byteArray.length; i++) {
       header += byteArray[i].toString(16);
    }
	switch (header) {
        case "89504e47":
            return "image/png";
        case "47494638":
            return "image/gif";
        case "ffd8ffe0":
        case "ffd8ffe1":
        case "ffd8ffe2":
        case "ffd8ffe3":
        case "ffd8ffe8":
            return "image/jpeg";
        default:
            return fallback;
    }
}

export default {
    components: {  
        CommonModal,
        Cropper,
        CircleStencil,
    },
    data: function() {
        return {
            image: {
                src: null,
                type: null,
                file: null,
                coordinates: null,
            },
        };
    },
    methods: {
        loading() {
            this.$emit('loading');
        },
        complete() {
            this.$emit('complete');
        },
        showModal() {
            this.$emit('showModal');
        },
        closeModal() {
            this.$emit('closeModal');
        },
        change({coordinates, canvas}) {
            this.image.coordinates = coordinates;
        },
        loadImage(files) {
            if (files && files[0]) {
                if (this.image.src) {
                    URL.revokeObjectURL(this.image.src);
                }

                const reader = new FileReader();
                const blob = URL.createObjectURL(files[0]);
                
                this.loading();
                reader.onload = (e) => {
                    this.image = {
                        src: blob,
                        type: getMimeType(e.target.result, files[0].type),
                        file: files[0],
                    };
                    const type = this.image.type;
                    if (type !== 'image/png') {
                        alert('Only accept PNG!');
                        this.closeModal();
                    } else {
                        this.showModal();
                    }
                    this.complete();
                }

                reader.readAsArrayBuffer(files[0]);
            }
        },
        async uploadImage() {
            this.loading();

            const form = new FormData();
            form.append('file', this.image.file);
            const coordinates = this.image.coordinates;
            Object.keys(coordinates).forEach(key => {
                form.append(key, coordinates[key]);
            });

            await api.upload(form)
                .then(response => {
                    console.log(response);
                })
                .catch(error => {
                    console.log(error.response);
                });
            this.complete();
            this.closeModal();
        },
    },
}
</script>

<style scoped>
.cropper {
  max-width: 70vw;
  max-height: 70vh;
  background: #DDD;
}
.modal__header {
  display: flex;
  justify-content: space-between;
  font-size: 20px;
  font-weight: 500;
  margin-bottom: 10px;
}
.modal__header span {
  cursor: pointer;
  margin-left: 10px;
}
.modal__footer button {
  width: 100%;
  margin-top: 10px;
  padding: 6px 2px;
}
.modal__close-btn:hover {
  color: red;
}
</style>