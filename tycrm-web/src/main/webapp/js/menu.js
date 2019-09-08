var vue = new Vue({
    el:'#app',
    data:{
        menuList:[]
    },
    methods:{
        getMenu(){
            axios.get("/getMenu",).then(result=> {
                if (result.status == 200) {
                    this.menuList = result.data;
                } else {
                    //不知道要干嘛？
                }
            })
        },

    },
    mounted(){
        this.getMenu();
    }
});