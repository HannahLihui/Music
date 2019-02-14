//设置全局表单提交格式
Vue.http.options.emulateJSON = true;

// Vue实例
new Vue({
    el: '#app',
    data() {
        return {
            checked: false,
            login: {
                username: '',
                password: '',
                remember: ''
            },
            flag: true,
            loading: {}, //loading动画
        };
    },
    methods: {
        /**
         * loading加载动画
         */
        loadings(){
            this.loading = this.$loading({
                lock: true,
                text: '拼命加载中',
                spinner: 'el-icon-loading',
            });
            setTimeout(() => {
                this.loading.close();
            }, 2000);
        },
        youke(){
        	sessionStorage.clear();
        	window.location.href="/youke";
        },
        submitForm(login) {
            this.$refs[login].validate((valid) => {
                if (valid) {
                    this.loadings(); //加载动画
                    //提交表单
                    //cookie.set("username",this.login.username,24);
                    this.$http.post('/login', {
                        username: this.login.username,
                        password: this.login.password,
                    }).then(result => {
                        // 判断用户是否登录成功，后端返回JSON格式数据，不然娶不到数据
                        if (result.body.success) {
                        	sessionStorage.setItem("name", this.login.username);
                            console.log(this.login.username);
                            window.alert(this.login.username);
                            sessionStorage.setItem("password", this.login.password);
                           
                            // console.log(this.$store);
                            // this.$store.dispatch("token", this.login);
                        	console.log(result.body.message);
                        	window.alert(result.body.message);
                        	sessionStorage.setItem("role",result.body.message);
                            if(result.body.message=='0')
                            	window.location.href = "/music";
                            else{
                            	window.location.href="/Userindex";
                            }
                            this.loading.close(); //关闭动画加载
                        } else {
                            // 弹出错误信息框
                            this.$emit(
                                'submit-form',
                                this.$message({
                                    message: '用户名或密码错误！',
                                    type: 'warning',
                                    duration: 6000
                                }),
                            );
                            // 清空表单状态
                            this.$refs[login].resetFields();
                        }
                    });
                } else {
                    this.$emit(
                        'submit-form',
                        this.$message({
                            message: '输入信息有误！',
                            type: 'warning',
                            duration: 6000
                        }),
                    );
                    return false;
                }
            });
        },
        loginEnter(login){
            this.submitForm(login);
        },

    }
});