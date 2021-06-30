<template>
    <div class="comment-input">
        <div class="comment-input__header">
            <user-image></user-image>
            <span>username</span>
        </div>
        <div class="comment-input__input">
            <textarea placeholder="댓글 달기"></textarea>
        </div>
        <div class="comment-input__footer">
            <button>등록</button>
        </div>
    </div>
</template>

<script>
import UserImage from '@/components/common/UserImage.vue';

export default {
    components: {
        UserImage,
    }
}
</script>

<style scoped>
.comment-input__header {
    display: flex;
    align-items: center;
}
.comment-input__input {
    margin: 6px 0;
    box-sizing: border-box;
}
.comment-input__input textarea {
    width: calc(100% - 30px);
    height: 60px;
    resize: none;
    margin: 4px;
    padding: 10px;
    font-family: inherit;
    font-size: inherit;
}
.comment-input__footer {
    text-align: right;
}
.comment-input__footer button {
    padding: 4px 30px;
    margin-right: 4px;
}
</style>