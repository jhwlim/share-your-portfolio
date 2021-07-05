<template>
    <div class="comment-list">
        <h3>comments</h3>
        <div v-for="(comment, index) in comments" :key="index" class="comment-item">
            <post-description-header
                :id="comment.writerId"
                :username="comment.writer"
                :date="comment.writeDate"></post-description-header>
            <div class="comment-item__content">
                {{ comment.content }}
            </div>
        </div>
    </div>
</template>

<script>
import PostDescriptionHeader from '@/components/post/PostDescriptionHeader.vue';

export default {
    components: {
        PostDescriptionHeader,
    },
    props: [
        'comments'
    ],
}
</script>

<style scoped>
.comment-list h3 {
    font-size: 22px;
    font-weight: 500;
    margin: 10px 0;
}
.comment-item {
    padding: 20px 0 30px;
    border-bottom: 1.5px #b6b6b6 solid;
}
.comment-item__content {
    margin-top: 10px;
}
</style>