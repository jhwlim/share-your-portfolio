<template>

    <div>
        <button @click="bringPostList">Bring Post List</button>
        <ul v-if="a">
            <a href="#" @click="bringImages(item)" v-for="(item, index) in this.postList" :key="index">
                <li>
                {{item.id}}
                {{item.title}}
                <br>
                <img id="first-page" :src="`http://localhost:8081/api/images/${item.writerId}/${item.id}/0`"/>                            
                </li>
            </a>                                                                
        </ul>

        <ul v-if="b">
            
            {{imgList.id}}
            {{imgList.title}}
            {{imgList.writerId}}
            
            <ul>
                <li id="imageList" v-for="i in imgList.numOfPage" :key="i">
                    <img id="list-of-img" :src="`http://localhost:8081/api/images/${imgList.writerId}/${imgList.id}/${i-1}`"/>
                </li>                
            </ul> 
        </ul>       
    </div>

</template>

<script>

import axios from 'axios';

var prefix = "/post";

export default{

    data (){
        return{

            postList: [     ],
            a: false,
            b: false,
            imgList: [      ],
            
        }
    },
    methods:{

        bringPostList(){

            this.a = true;

            axios.get(`${prefix}/postList`)
            .then(response => {

                let pl = response.data;

                console.log(JSON.stringify(pl));

                for(var idx in pl){
                    console.log(pl[idx]);
                    console.log(pl[idx].numOfPage);
                }

                this.postList = pl;

            })
            .catch(function(error){
                console.log(error)
            });
        },

        bringImages(item){
            
            this.b = true;

            this.imgList = item;          
        }

    }
}
</script>

<style>
#first-page {
  width: 300px;
  height: 150px;
  object-fit: scale-down;
}

#list-of-img {
  width: 300px;
  height: 150px;
  object-fit: scale-down;
}

#imageList{
    float: left;
}

</style>