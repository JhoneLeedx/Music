package com.jhonlee.music.pojo;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class Player {


    /**
     * artistCount : 83
     * artists : [{"id":9269,"name":"容祖儿","picUrl":"http://p4.music.126.net/VV4v0_aEuyjdnIuH6RP-6w==/5834008697196668.jpg","alias":["Joey Yung"],"albumSize":85,"picId":5834008697196668,"img1v1Url":"http://p3.music.126.net/RA9xjQ0ABACRcfKwutGDnA==/5946158883315120.jpg","img1v1":5946158883315120,"mvSize":354,"followed":false,"trans":null},{"id":96266,"name":"Maroon 5","picUrl":"http://p3.music.126.net/KG4t8UkdZoJt4BHc45ay9A==/18503681184431512.jpg","alias":[],"albumSize":54,"picId":18503681184431512,"img1v1Url":"http://p3.music.126.net/h-ynyQrpyIvfJeW_DeaqHA==/1385384666932895.jpg","img1v1":1385384666932895,"transNames":["魔力红"],"mvSize":75,"followed":false,"trans":"魔力红"},{"id":90331,"name":"Charlie Puth","picUrl":"http://p3.music.126.net/rVpFELYLsrt6dCaPHdRjrg==/2945591652186912.jpg","alias":[],"albumSize":37,"picId":2945591652186912,"img1v1Url":"http://p3.music.126.net/e8VTITh9l1b9xnTze8nelQ==/18671906465134590.jpg","img1v1":18671906465134590,"transNames":["查理·帕斯"],"mvSize":70,"followed":false,"trans":"查理·帕斯"},{"id":964486,"name":"Tobu","picUrl":"http://p3.music.126.net/a6WJyAswNrW6FYZ6JtvCRg==/1367792467198145.jpg","alias":["Toms Burkovskis"],"albumSize":54,"picId":1367792467198145,"img1v1Url":"http://p3.music.126.net/QlOUmYAuEyqKO4g96QM1kQ==/5989039837081565.jpg","img1v1":5989039837081565,"transNames":["7obu"],"mvSize":62,"followed":false,"trans":"7obu"},{"id":1137098,"name":"陈一发儿","picUrl":"http://p4.music.126.net/sRBctPc3FNsv_x1fSeH7iQ==/3440371884139728.jpg","alias":[],"albumSize":1,"picId":3440371884139728,"img1v1Url":"http://p4.music.126.net/zt6Hm37KjdKfayQ7Vk-T8Q==/3299634396372579.jpg","accountId":19570392,"img1v1":3299634396372579,"mvSize":0,"followed":false,"trans":null},{"id":865134,"name":"日语听力","picUrl":"http://p4.music.126.net/GQmirUSMfvPEorWaut4NWw==/5845003813406526.jpg","alias":[],"albumSize":48,"picId":5845003813406526,"img1v1Url":"http://p4.music.126.net/m9GRB1Q4VCnBzmYIiciARQ==/5896680859851047.jpg","img1v1":5896680859851047,"mvSize":0,"followed":false,"trans":null},{"id":33184,"name":"Ed Sheeran","picUrl":"http://p4.music.126.net/YIx9H1kyGyhbWZBfJ9-pIg==/18594940650636277.jpg","alias":[],"albumSize":46,"picId":18594940650636277,"img1v1Url":"http://p3.music.126.net/7QK82incNi3k9Gfpot_ykg==/18636722092498224.jpg","accountId":416608258,"img1v1":18636722092498224,"mvSize":134,"followed":false,"trans":null},{"id":990289,"name":"れをる","picUrl":"http://p3.music.126.net/vPgS9BjwMKNaTATevXBXfg==/6657542907991862.jpg","alias":["Reworu","Reol"],"albumSize":5,"picId":6657542907991862,"img1v1Url":"http://p4.music.126.net/t7s8OjovMdachonDJoNQPw==/3283141725800255.jpg","img1v1":3283141725800255,"mvSize":2,"followed":false,"trans":null},{"id":10584,"name":"张柏芝","picUrl":"http://p4.music.126.net/OGFQEoEh2L6ddmEMHOGYQg==/217703302317069.jpg","alias":[],"albumSize":17,"picId":217703302317069,"img1v1Url":"http://p3.music.126.net/tumiSW2k54zZuygcxze_7Q==/218802813944832.jpg","img1v1":218802813944832,"mvSize":4,"followed":false,"trans":null},{"id":53243,"name":"Dr. Dre","picUrl":"http://p3.music.126.net/UWBTA2XvIkZHnid5j7N2Wg==/389227116235241.jpg","alias":[],"albumSize":33,"picId":389227116235241,"img1v1Url":"http://p4.music.126.net/3a2141gflCnkkcsx_aMMhA==/426610511579702.jpg","img1v1":426610511579702,"transNames":["安德烈.罗梅勒.杨"],"mvSize":10,"followed":false,"trans":"安德烈.罗梅勒.杨"}]
     */

    private int artistCount;
    private List<Artist> artists;

    public int getArtistCount() {
        return artistCount;
    }

    public void setArtistCount(int artistCount) {
        this.artistCount = artistCount;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
