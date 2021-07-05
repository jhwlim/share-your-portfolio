<template>
    <div class="post">
        <div class="post__image pointer" @click="moveToPost()">
            <!-- <img :src="post.imagePath" alt=""> -->
            <img src="@/assets/image/post-1.jpg" alt="">
        </div>
        <div class="post__description">
            <post-description-header 
                :id="post.writerId" 
                :username="post.writer" 
                :date="post.writeDate"></post-description-header>
            <post-description-content
                :id="post.id"
                :title="post.title"
                :content="post.content"></post-description-content>
            <post-description-footer
                :viewCount="post.viewCount"
                :commentCount="post.commentCount"
                :likeCount="post.likeCount"
                :isLiked="post.isLiked"></post-description-footer>
        </div>
    </div>
</template>

<script>
import PostDescriptionHeader from './PostDescriptionHeader.vue';
import PostDescriptionContent from './PostDescriptionContent.vue';
import PostDescriptionFooter from './PostDescriptionFooter.vue';

export default {
    components: {
        PostDescriptionHeader,
        PostDescriptionContent,
        PostDescriptionFooter,
    },
    props: [
        'post'
    ],
    methods: {
        moveToPost() {
            this.$router.push(`/post/${this.post.id}`)
        },
    }
}
</script>

<style scoped>
.post {
    display: flex;
    margin-bottom: 30px;
}
.post__image {
    width: 450px;
    height: 320px;
    overflow: hidden;
}
.post__image img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
.post__description {
    padding: 8px 20px;
    width: 400px;
}
</style>