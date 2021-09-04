<template>
<div>
    <div class="post-header">
        <span>All Posts</span>

        <span id="upload-button" v-on:click="openModal">Upload Posts</span>
    </div>
        <MyModal v-if="showModal">
            <h1 slot="header" class="modal__header">Flex Your PortFolio</h1>
                
                <div slot="body" class="modal__body">
                    <div class="upload-page">
                        <form v-on:submit.prevent="onUpload">
                        
                        <div class="modal-inside">
                            <div class="input-box">            
                                <span class="details">Title</span>
                                <input v-model="title" placeholder="type the title of portfolio" required>
                            </div>

                            <div class="input-box">            
                                <span class="details">Content</span>            
                                <textarea v-model="content" placeholder="summarize your content of portfolio"></textarea>
                            </div>

                            <div class="category-details">
                                <input type="radio" name="category" id="dot-1" value="IT" v-model="category">
                                <input type="radio" name="category" id="dot-2" value="Design" v-model="category">
                                <input type="radio" name="category" id="dot-3" value="architect" v-model="category">
                                <input type="radio" name="category" id="dot-4" value="Marketing" v-model="category">
                                <input type="radio" name="category" id="dot-5" value="Accounting" v-model="category">

                                <span class="category-title">Category</span>
                                <div class="category">
                                    <label for="dot-1">             
                                        <span class="list-of-category">IT</span>
                                        <span class="dot one"></span>
                                    </label>
                                    <label for="dot-2">
                                        <span class="list-of-category">Design</span>
                                        <span class="dot two"></span>
                                    </label>
                                    <label for="dot-3">
                                        <span class="list-of-category">Architect</span>
                                        <span class="dot three"></span>
                                    </label>
                                    <label for="dot-4">
                                        <span class="list-of-category">Marketing</span>
                                        <span class="dot four"></span>
                                    </label>
                                    <label for="dot-5">
                                        <span class="list-of-category">Accounting</span>
                                        <span class="dot five"></span>
                                    </label>
                                </div>
                            </div>

                            <div class="filebox"> 
                                <span class="filebox-title">Upload pdf file only</span>
                                <input class="upload-name" value="파일선택" v-model="fileName" disabled="disabled"> 
                                <label for="ex_filename">Post</label> 
                                <input type="file" @change="onFileSelected" ref="fileInput" id="ex_filename" class="upload-hidden"> 
                            </div>
                        </div>
                        
                        <div class="list-of-button">
                            <button id="post-button" type="submit">Submit</button>
                            <button id="post-button" v-on:click="closeModal">Close</button>
                        </div>
                        </form>
                    </div>
                </div>
            <span slot="footer">                       
                        
            </span>
        </MyModal>
    </div>

</template>

<script>
import axios from 'axios';
import { mapGetters } from 'vuex';
import MyModal from '@/components/common/CommonModal.vue';

var regex = new RegExp("pdf$", 'i');
var maxSize = 5242880; //5MB
var prefix = "/post";

export default {

    components: {
        MyModal,
    },

    computed: {
        ...mapGetters(['getUid']),   
    },

    data(){
        return{
            showModal: false,
            selectedFile: null,
            fileName: '',
            title : '',
            content : '',
            category: '',
        }
    },

    methods:{
        openModal() {
        this.showModal = true;
        },
        closeModal() {
        this.showModal = false;
        this.title = '';
        this.content = '';
        this.category = '';
        this.selectedFile = null;
        this.fileName= '';   
        },

       checkExtension(fileName, fileSize){
            if(fileSize >= maxSize){
                alert("파일 사이즈가 초과하였습니다.");
                return false;
            }

            if(regex.test(fileName) == 0){
                alert("pdf외에 파일은 업로드 할 수 없습니다.");
                return false;
            }

            return true;
        },

        onFileSelected(event){
            this.selectedFile = event.target.files[0]
            this.fileName =  event.target.files[0].name
        },

        onUpload(){

            const fd = new FormData();
            
            if(!this.checkExtension(this.selectedFile.name, this.selectedFile.size)){
                
                return false;
            }

            else{

            fd.append('title', this.title);

            fd.append('content', this.content);       
            
            fd.append('category', this.category);

            fd.append('file', this.selectedFile, this.selectedFile.name);

            fd.append('writerId', this.getUid);
        
            axios.post(`${prefix}/uploadFile`, fd, {

                Headers: {
                    'Content-Type' : 'multipart/form-data'
                },
                               
                onUploadProgress : uploadEvent => {
                    console.log('Upload Progress: ' + Math.round(uploadEvent.loaded / uploadEvent.total * 100) + '%')
                }
                
            })
                .then(res =>{

                    if(res.status === 200){
                        alert("파일 업로드가 완료되었습니다.");
                        this.closeModal();
                    }       
                })
                .catch(error =>{

                    if(error.response.status === 404){
                        alert('필수 정보가 입력되지 않았습니다. 다시 한번 확인해주세요.')
                    }
                    else if(error.response.status === 400){
                        alert("올바르지 않은 파일입니다. 다시 한번 확인해주세요.");
                    }
                })
               
            }
            this.title = '';
            this.content = '';
            this.category = '';
            this.selectedFile = null;
            this.fileName= '';           
        },

    }

    
}
</script>

<style>
.post-header {
    height: 60px;
    display: flex;
    align-items: center;
    padding: 0 2px;
    justify-content: space-between;
}
.post-header span {
    font-size: 18px;
    letter-spacing: 0.8px;
    font-weight: 500;
}

.post-header button {
    font-size: 18px;
    letter-spacing: 0.8px;
    font-weight: 500;
}

.modal__header {
	font-weight: 700;
	font-size: 24px;
    display: flex;
    justify-content: center;
    align-items: center;
}

.modal__sub_header {
    font-weight: 500;
    font-size: 18px;
}

.modal__body {
	width: 600px;
    height: 500px;
    margin-top: 30px;   
}

.modal-inside{
    margin-left: 50px;
}

#upload-button{
    cursor: pointer;
}

.details{
  display: block;
  font-weight: 500;
  margin-bottom: 5px;
}

.input-box{
    margin-bottom: 10px;
}

.input-box input{
  height: 45px;
  width: 85%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}

.input-box textarea{
  height: 100px;
  width: 85%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
  resize:none;
}

.input-box input:focus,
.input-box textarea:focus
{
  border-color: black;
}

.category-details{
    margin-bottom: 30px;
}

.category-title{
  font-size: 20px;
  font-weight: 500;
 }

 form .category{
   display: flex;
   width: 80%;
   margin: 14px 0 ;
   justify-content: space-between;
 }
 form .category label{
   display: flex;
   align-items: center;
   cursor: pointer;
 }
 form .category label .dot{
  height: 18px;
  width: 18px;
  border-radius: 50%;
  margin-right: 10px;
  margin-left: 10px;
  background: #d9d9d9;
  border: 5px solid transparent;
  transition: all 0.3s ease;
}
 #dot-1:checked ~ .category label .one,
 #dot-2:checked ~ .category label .two,
 #dot-3:checked ~ .category label .three,
 #dot-4:checked ~ .category label .four,
 #dot-5:checked ~ .category label .five{
   background: linear-gradient(45deg, black, transparent);
   border-color: #d9d9d9;
 }
 form input[type="radio"]{
   display: none;
   
 }

#post-button {
   height: 45px;
   margin: 35px 0;
 }

 #post-button {
   width: 30%;
   margin: 35px 0;
   border-radius: 5px;
   border: none;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background: linear-gradient(135deg, black, white);
   margin-left: 10px;
   margin-right: 10px;
   
 }
 #post-button:hover{
  background: linear-gradient(-135deg, black, white);
  }

.list-of-button{
    display: flex;
    justify-content:center;
}

.filebox-title{
  font-size: 20px;
  font-weight: 500;
 }

.filebox input[type="file"] {
     position: absolute; 
     width: 1px; 
     height: 1px; 
     padding: 0; 
     margin: -1px; 
     overflow: hidden; 
     clip:rect(0,0,0,0); border: 0;
} 
.filebox label { 
    display: inline-block; 
    margin-top: 30px;
    padding: 5px 10px; 
    font-size: inherit; 
    line-height: normal; 
    vertical-align: middle; 
    cursor: pointer; 
    border: 1px solid #ebebeb; 
    border-bottom-color: #e2e2e2; 
    border-radius: 5px; 
} 
.filebox .upload-name {
    display: inline-block; 
    width: 74%;
    margin-top: 30px;
    padding: 5px 10px;
    font-size: inherit; 
    font-family: inherit; 
    line-height: normal; 
    vertical-align: middle; 
    background-color: #f5f5f5; 
    border: 1px solid #ebebeb; 
    border-bottom-color: #e2e2e2; 
    border-radius: 5px; 
    -webkit-appearance: none; 
    -moz-appearance: none; appearance: none; 
}
</style>