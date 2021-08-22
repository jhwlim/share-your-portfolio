<template>
    <center-card>
        <template v-slot:content>
            <v-form width="600">
                <v-text-field 
                    label="이메일"
                    v-model="loginForm.email"
                    :rules="rules.email"
                ></v-text-field>
                <v-text-field 
                    label="비밀번호"
                    v-model="loginForm.password"
                    :rules="rules.password"
                ></v-text-field>
            </v-form>
        </template>
        <template v-slot:actions>
            <v-flex>
                <v-btn 
                    block 
                    color="primary"
                    class="my-2"
                >
                    로그인
                </v-btn>
                <router-link to="/signup">
                    <v-btn 
                        block
                        color="secondary"
                    >
                        회원가입
                    </v-btn>
                </router-link>
            </v-flex>
        </template>
    </center-card>
</template>

<script>
import CenterCard from '@/components/layout/CenterCard.vue';

export default {
    name: 'LoginView',
    components: {
        CenterCard,
    },
    data: function() {
        return {
            loginForm: {                
                email: '',
                password: '',
            },
            rules: {
                email: [
                    value => !!value || '이메일을 입력해주세요.',
                ],
                password: [
                    value => !!value || '비밀번호를 입력해주세요.',
                ],
            }
        }
    },
}
</script>