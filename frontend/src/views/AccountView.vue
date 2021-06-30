<template>
    <div class="container">
        <account-image-edit></account-image-edit>
        <account-info></account-info>
    </div>
</template>

<script>
import AccountImageEdit from '@/components/account/AccountImageEdit.vue';
import AccountInfo from '@/components/account/AccountInfo.vue';
import { mapGetters } from 'vuex';

export default {
    components: {
        AccountImageEdit,
        AccountInfo,
    },
    computed: {
        ...mapGetters([
            'getUid',
            'getUsername'
        ]),
    }
}
</script>

<style scoped>
.container {
    margin: 60px auto;
    max-width: 550px;
    border: 1px solid lightgray;
    padding: 50px 80px;
}
</style>