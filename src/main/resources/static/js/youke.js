new Vue({
	el: '#app',
data() {
	 
    return {
    	brand:'',
    	musicSearch:'',
    	 change: {
             category: [],
             brand: [],
             price: []
         },
    	 classifyData: {
             category: [],
             brand: [],
         },
    		 news: [{
                 id: '',
                 title: '',
                 date: '',
                 img: '', 
                 content: ''
             }],
             mymusic: [{
                 id: '',
                 name: '',
                 num: '',
                 url:'',
                 img: '',
                 brand: '',
                 singer: ''
             }],
    	
    	 music:{
             isPlay:false,
             currentTime:0,
             maxTime:0,
             volume:100
           },
    	
      tableData: [{
    	  id: '1',
          name: '林俊杰',
          num: '100',
          img: '',
          brand: '',
          singer: '',
          url:'../dist/music/1.mp3'
      }, {
    	  id: '',
          name: '',
          num: '',
          img: '',
          brand: '',
          singer: '',
          url:''
      }, {
    	  id: '',
          name: '',
          num: '',
          img: '',
          brand: '',
          singer: '',
          url:''
      }, {
    	  id: '',
          name: '',
          num: '',
          img: '',
          brand: '',
          singer: '',
          url:''
      }]
    }
  },
  created() {
	  this.clear();
	  this.getClassifyData();
      // this.findAll();
      this.search();
      this.Musicsearch();
     
  },
  methods: {
	  clear(){
		  sessionStorage.clear();  
	  },
	  selectMethod(val){
    	  //window.alert(val);
    	  //window.alert(this.brand);
              this.$http.post('music/findByBrand?brand=' + this.brand).then(result => {
                  this.mymusic = result.body;
                  console.log(result);
              });
          
      },
	  download(){
		 
			  window.alert("等先登录方可下载");
			  
	  },
 getClassifyData() {
          
          this.classifyData.brand = ['英文','粤语','民族','流行音乐','摇滚音乐'];
      },
	  search() {
          
          this.$http.post('/news/findAll').then(result => {
              console.log(result);
              this.news= result.body;
             
             
          });

      },
      searchMusic(){
    	  
    	  this.$http.post('/music/findByName?musicSearch=' + this.musicSearch).then(result => {
              console.log(result);
              this.mymusic = result.body;
          });
      },
      Musicsearch() {
         
          this.$http.post('/music/findAll').then(result => {
              console.log(result);
              this.mymusic = result.body;
              sessionStorage.setItem("src", this.mymusic.url);
             
             
          });

      },
    resetDateFilter() {
      this.$refs.filterTable.clearFilter('date');
    },
    clearFilter() {
      this.$refs.filterTable.clearFilter();
    },
    formatter(row, column) {
      return row.address;
    },
    filterTag(value, row) {
      return row.tag === value;
    },
    filterHandler(value, row, column) {
      const property = column['property'];
      return row[property] === value;
    },
    listenMusic(){
        if(!this.$refs.music){
          return
        }
        if(this.$refs.music.readyState){
          this.music.maxTime = this.$refs.music.duration
        }
        this.music.isPlay=!this.$refs.music.paused
        this.music.currentTime = this.$refs.music.currentTime
      },
      play(){
        if(this.$refs.music.paused){
          this.$refs.music.play()
        }else{
          this.$refs.music.pause()
        }
        this.music.isPlay=!this.$refs.music.paused
        this.$nextTick(()=>{
          document.getElementById('play').blur()
        })
      },
      changeTime(time){
        this.$refs.music.currentTime = time
      },
      changeVolume(v){
        this.music.volume += v 
        if(this.music.volume>100){
          this.music.volume = 100
        }
        if(this.music.volume<0){
          this.music.volume = 0
        }
        this.$refs.music.volume = this.music.volume/100
      },
      formatTime(time){
        let it = parseInt(time)
        let m = parseInt(it/60)
        let s = parseInt(it%60)
        return (m<10?"0":"")+parseInt(it/60)+":"+(s<10?"0":"")+parseInt(it%60)
      }


  }
});