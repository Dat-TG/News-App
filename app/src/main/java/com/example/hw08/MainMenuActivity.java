package com.example.hw08;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class MainMenuActivity extends Activity {
    ArrayAdapter<String> adapterMainSubjects;
    ListView myMainListView;
    Context context;
    SingleItem selectedNewsItem;
    // hard-coding main NEWS categories (TODO: use a resource file)
    String[][] myUrlCaptionMenu;
    String name;
    String[] myUrlCaption;
    String[] myUrlAddress;
    int logo;
    ImageView img;

    public static String niceDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM d, yyyy",
                Locale.US);
        return sdf.format(new Date());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        name= getIntent().getStringExtra("NAME");
        logo=getIntent().getIntExtra("logo",0);
        img=findViewById(R.id.logo_main);
        img.setBackgroundResource(logo);
        if (Objects.equals(name, "NPR")) {
            myUrlCaptionMenu=new String[7][2];
            myUrlCaptionMenu[0][0]="https://feeds.npr.org/510289/podcast.xml";
            myUrlCaptionMenu[0][1]="Business";
            myUrlCaptionMenu[1][0]="https://feeds.npr.org/344098539/podcast.xml";
            myUrlCaptionMenu[1][1]="Comedy";
            myUrlCaptionMenu[2][0]="https://feeds.npr.org/510308/podcast.xml";
            myUrlCaptionMenu[2][1]="Science";
            myUrlCaptionMenu[3][0]="https://feeds.npr.org/510298/podcast.xml";
            myUrlCaptionMenu[3][1]="Technology";
            myUrlCaptionMenu[4][0]="https://feeds.npr.org/510306/podcast.xml";
            myUrlCaptionMenu[4][1]="Music";
            myUrlCaptionMenu[5][0]="https://feeds.npr.org/510354/podcast.xml";
            myUrlCaptionMenu[5][1]="Kid & family";
            myUrlCaptionMenu[6][0]="https://feeds.npr.org/510309/podcast.xml";
            myUrlCaptionMenu[6][1]="Society & culture";
        }
        else if (Objects.equals(name, "VNEXPRESS")) {
            myUrlCaptionMenu=new String[13][2];
            myUrlCaptionMenu[0][0]="https://vnexpress.net/rss/tin-moi-nhat.rss";
            myUrlCaptionMenu[0][1]="Tin mới nhất";
            myUrlCaptionMenu[1][0]="https://vnexpress.net/rss/the-gioi.rss";
            myUrlCaptionMenu[1][1]="Thế giới";
            myUrlCaptionMenu[2][0]="https://vnexpress.net/rss/thoi-su.rss";
            myUrlCaptionMenu[2][1]="Thời sự";
            myUrlCaptionMenu[3][0]="https://vnexpress.net/rss/kinh-doanh.rss";
            myUrlCaptionMenu[3][1]="Kinh doanh";
            myUrlCaptionMenu[4][0]="https://vnexpress.net/rss/giai-tri.rss";
            myUrlCaptionMenu[4][1]="Giải trí";
            myUrlCaptionMenu[5][0]="https://vnexpress.net/rss/the-thao.rss";
            myUrlCaptionMenu[5][1]="Thể thao";
            myUrlCaptionMenu[6][0]="https://vnexpress.net/rss/phap-luat.rss";
            myUrlCaptionMenu[6][1]="Pháp luật";
            myUrlCaptionMenu[7][0]="https://vnexpress.net/rss/tin-noi-bat.rss";
            myUrlCaptionMenu[7][1]="Tin nổi bật";
            myUrlCaptionMenu[8][0]="https://vnexpress.net/rss/suc-khoe.rss";
            myUrlCaptionMenu[8][1]="Sức khỏe";
            myUrlCaptionMenu[9][0]="https://vnexpress.net/rss/gia-dinh.rss";
            myUrlCaptionMenu[9][1]="Đời sống";
            myUrlCaptionMenu[10][0]="https://vnexpress.net/rss/du-lich.rss";
            myUrlCaptionMenu[10][1]="Du lịch";
            myUrlCaptionMenu[11][0]="https://vnexpress.net/rss/khoa-hoc.rss";
            myUrlCaptionMenu[11][1]="Khoa học";
            myUrlCaptionMenu[12][0]="https://vnexpress.net/rss/cuoi.rss";
            myUrlCaptionMenu[12][1]="Cười";
        }
        else if (Objects.equals(name, "THANHNIEN")) {
            myUrlCaptionMenu=new String[14][2];
            myUrlCaptionMenu[0][0]="https://thanhnien.vn/rss/home.rss";
            myUrlCaptionMenu[0][1]="Trang chủ";
            myUrlCaptionMenu[1][0]="https://thanhnien.vn/rss/video-316.rss";
            myUrlCaptionMenu[1][1]="Video";
            myUrlCaptionMenu[2][0]="https://thanhnien.vn/rss/thoi-su-4.rss";
            myUrlCaptionMenu[2][1]="Thời sự";
            myUrlCaptionMenu[3][0]="https://thanhnien.vn/rss/chao-ngay-moi-2.rss";
            myUrlCaptionMenu[3][1]="Chào ngày mới";
            myUrlCaptionMenu[4][0]="https://thanhnien.vn/rss/the-gioi-66.rss";
            myUrlCaptionMenu[4][1]="Thế giới";
            myUrlCaptionMenu[5][0]="https://thanhnien.vn/rss/van-hoa-93.rss";
            myUrlCaptionMenu[5][1]="Văn hóa";
            myUrlCaptionMenu[6][0]="https://thanhnien.vn/rss/giai-tri-285.rss";
            myUrlCaptionMenu[6][1]="Giải trí";
            myUrlCaptionMenu[7][0]="https://thanhnien.vn/rss/the-thao-318.rss";
            myUrlCaptionMenu[7][1]="Thể thao";
            myUrlCaptionMenu[8][0]="https://thanhnien.vn/rss/tai-chinh-kinh-doanh-49.rss";
            myUrlCaptionMenu[8][1]="Tài chính - kinh doanh";
            myUrlCaptionMenu[9][0]="https://thanhnien.vn/rss/doi-song-17.rss";
            myUrlCaptionMenu[9][1]="Đời sống";
            myUrlCaptionMenu[10][0]="https://thanhnien.vn/rss/du-lich-234.rss";
            myUrlCaptionMenu[10][1]="Du lịch";
            myUrlCaptionMenu[11][0]="https://thanhnien.vn/rss/gioi-tre-69.rss";
            myUrlCaptionMenu[11][1]="Giới trẻ";
            myUrlCaptionMenu[12][0]="https://thanhnien.vn/rss/giao-duc-26.rss";
            myUrlCaptionMenu[12][1]="Giáo dục";
            myUrlCaptionMenu[13][0]="https://thanhnien.vn/rss/cong-nghe-game-315.rss";
            myUrlCaptionMenu[13][1]="Công nghệ - Game";
        }
        else if (Objects.equals(name, "LAODONG")) {
            myUrlCaptionMenu=new String[9][2];
            myUrlCaptionMenu[0][0]="https://laodong.vn/rss/cong-doan.rss";
            myUrlCaptionMenu[0][1]="Công đoàn";
            myUrlCaptionMenu[1][0]="https://laodong.vn/rss/xa-hoi.rss";
            myUrlCaptionMenu[1][1]="Xã hội";
            myUrlCaptionMenu[2][0]="https://laodong.vn/rss/thoi-su.rss";
            myUrlCaptionMenu[2][1]="Thời sự";
            myUrlCaptionMenu[3][0]="https://laodong.vn/rss/the-thao.rss";
            myUrlCaptionMenu[3][1]="Thể thao";
            myUrlCaptionMenu[4][0]="https://laodong.vn/rss/the-gioi.rss";
            myUrlCaptionMenu[4][1]="Thế giới";
            myUrlCaptionMenu[5][0]="https://laodong.vn/rss/phap-luat.rss";
            myUrlCaptionMenu[5][1]="Pháp luật";
            myUrlCaptionMenu[6][0]="https://laodong.vn/rss/suc-khoe.rss";
            myUrlCaptionMenu[6][1]="Sức khỏe";
            myUrlCaptionMenu[7][0]="https://laodong.vn/rss/van-hoa-giai-tri.rss";
            myUrlCaptionMenu[7][1]="Văn hóa - Giải trí";
            myUrlCaptionMenu[8][0]="https://laodong.vn/rss/xe.rss";
            myUrlCaptionMenu[8][1]="Xe+";
        }
        else if (Objects.equals(name, "TUOITRE")) {
            myUrlCaptionMenu=new String[12][2];
            myUrlCaptionMenu[0][0]="https://tuoitre.vn/rss/tin-moi-nhat.rss";
            myUrlCaptionMenu[0][1]="Tin mới nhất";
            myUrlCaptionMenu[1][0]="https://tuoitre.vn/rss/the-gioi.rss";
            myUrlCaptionMenu[1][1]="Thế giới";
            myUrlCaptionMenu[2][0]="https://tuoitre.vn/rss/thoi-su.rss";
            myUrlCaptionMenu[2][1]="Thời sự";
            myUrlCaptionMenu[3][0]="https://tuoitre.vn/rss/kinh-doanh.rss";
            myUrlCaptionMenu[3][1]="Kinh doanh";
            myUrlCaptionMenu[4][0]="https://tuoitre.vn/rss/giai-tri.rss";
            myUrlCaptionMenu[4][1]="Giải trí";
            myUrlCaptionMenu[5][0]="https://tuoitre.vn/rss/the-thao.rss";
            myUrlCaptionMenu[5][1]="Thể thao";
            myUrlCaptionMenu[6][0]="https://tuoitre.vn/rss/phap-luat.rss";
            myUrlCaptionMenu[6][1]="Pháp luật";
            myUrlCaptionMenu[7][0]="https://tuoitre.vn/rss/gia-that.rss";
            myUrlCaptionMenu[7][1]="Giả thật";
            myUrlCaptionMenu[8][0]="https://tuoitre.vn/rss/suc-khoe.rss";
            myUrlCaptionMenu[8][1]="Sức khỏe";
            myUrlCaptionMenu[9][0]="https://tuoitre.vn/rss/nhip-song-tre.rss";
            myUrlCaptionMenu[9][1]="Nhịp sống trẻ";
            myUrlCaptionMenu[10][0]="https://tuoitre.vn/rss/du-lich.rss";
            myUrlCaptionMenu[10][1]="Du lịch";
            myUrlCaptionMenu[11][0]="https://tuoitre.vn/rss/nhip-song-so.rss";
            myUrlCaptionMenu[11][1]="Công nghệ";
        }
        else if (Objects.equals(name, "GAMEK")) {
            myUrlCaptionMenu=new String[7][2];
            myUrlCaptionMenu[0][0]="https://toquoc.vn/rss/home.rss";
            myUrlCaptionMenu[0][1]="Trang chủ";
            myUrlCaptionMenu[1][0]="https://gamek.vn/thi-truong.rss";
            myUrlCaptionMenu[1][1]="Thị trường";
            myUrlCaptionMenu[2][0]="https://gamek.vn/pc-console.rss";
            myUrlCaptionMenu[2][1]="PC Console";
            myUrlCaptionMenu[3][0]="https://gamek.vn/esport.rss";
            myUrlCaptionMenu[3][1]="Esport";
            myUrlCaptionMenu[4][0]="https://gamek.vn/mobile-social.rss";
            myUrlCaptionMenu[4][1]="Mobile";
            myUrlCaptionMenu[5][0]="https://gamek.vn/gaming-gear.rss";
            myUrlCaptionMenu[5][1]="Gaming gear";
            myUrlCaptionMenu[6][0]="https://gamek.vn/manga-film.rss";
            myUrlCaptionMenu[6][1]="Manga - Phim";
        }
        else if (Objects.equals(name, "TOQUOC")) {
            myUrlCaptionMenu=new String[11][2];
            myUrlCaptionMenu[0][0]="https://toquoc.vn/rss/home.rss";
            myUrlCaptionMenu[0][1]="Home";
            myUrlCaptionMenu[1][0]="https://toquoc.vn/rss/thoi-su-1.rss";
            myUrlCaptionMenu[1][1]="Thời sự";
            myUrlCaptionMenu[2][0]="https://toquoc.vn/rss/van-hoa-10.rss";
            myUrlCaptionMenu[2][1]="Văn hóa";
            myUrlCaptionMenu[3][0]="https://toquoc.vn/rss/the-thao-15.rss";
            myUrlCaptionMenu[3][1]="Thể thao";
            myUrlCaptionMenu[4][0]="https://toquoc.vn/rss/du-lich-18.rss";
            myUrlCaptionMenu[4][1]="Du lịch";
            myUrlCaptionMenu[5][0]="https://toquoc.vn/rss/the-gioi-5.rss";
            myUrlCaptionMenu[5][1]="Thế giới";
            myUrlCaptionMenu[6][0]="https://toquoc.vn/rss/kinh-te-2.rss";
            myUrlCaptionMenu[6][1]="Kinh tế";
            myUrlCaptionMenu[7][0]="hhttps://toquoc.vn/rss/giai-tri-11.rss";
            myUrlCaptionMenu[7][1]="Giải trí";
            myUrlCaptionMenu[8][0]="https://toquoc.vn/rss/giao-duc-78.rss";
            myUrlCaptionMenu[8][1]="Giáo dục";
            myUrlCaptionMenu[9][0]="https://toquoc.vn/rss/suc-khoe-25.rss";
            myUrlCaptionMenu[9][1]="Sức khỏe";
            myUrlCaptionMenu[10][0]="https://toquoc.vn/rss/to-quoc-media-29.rss";
            myUrlCaptionMenu[10][1]="Tổ Quốc Media";
        }
        else if (Objects.equals(name, "DANVIET")) {
            myUrlCaptionMenu=new String[12][2];
            myUrlCaptionMenu[0][0]="https://danviet.vn/rss/home.rss";
            myUrlCaptionMenu[0][1]="Trang chủ";
            myUrlCaptionMenu[1][0]="https://danviet.vn/rss/the-gioi-1007.rss";
            myUrlCaptionMenu[1][1]="Thế giới";
            myUrlCaptionMenu[2][0]="https://danviet.vn/rss/nha-nong-1009.rss";
            myUrlCaptionMenu[2][1]="Nhà nông";
            myUrlCaptionMenu[3][0]="https://danviet.vn/rss/the-thao-1035.rss";
            myUrlCaptionMenu[3][1]="Thể thao";
            myUrlCaptionMenu[4][0]="https://danviet.vn/rss/phap-luat-1008.rss";
            myUrlCaptionMenu[4][1]="Pháp luật";
            myUrlCaptionMenu[5][0]="https://danviet.vn/rss/kinh-te-1004.rss";
            myUrlCaptionMenu[5][1]="Kinh tế";
            myUrlCaptionMenu[6][0]="https://danviet.vn/rss/giao-duc-1196.rss";
            myUrlCaptionMenu[6][1]="Giáo dục";
            myUrlCaptionMenu[7][0]="https://danviet.vn/rss/doi-song-1190.rss";
            myUrlCaptionMenu[7][1]="Đời sống";
            myUrlCaptionMenu[8][0]="https://danviet.vn/rss/van-hoa-giai-tri-1006.rss";
            myUrlCaptionMenu[8][1]="Văn hóa - Giải trí";
            myUrlCaptionMenu[9][0]="https://danviet.vn/rss/lang-cuoi-24h-1029.rss";
            myUrlCaptionMenu[9][1]="Làng cười";
            myUrlCaptionMenu[10][0]="https://danviet.vn/rss/chuyen-dong-sai-gon-1264.rss";
            myUrlCaptionMenu[10][1]="Chuyển động Sài Gòn";
            myUrlCaptionMenu[11][0]="https://danviet.vn/rss/ha-noi-hom-nay-1209.rss";
            myUrlCaptionMenu[11][1]="Hà Nội hôm nay";
        }
        myUrlCaption = new String[myUrlCaptionMenu.length];
        myUrlAddress = new String[myUrlCaptionMenu.length];
        for (int i = 0; i < myUrlAddress.length; i++) {
            myUrlAddress[i] = myUrlCaptionMenu[i][0];
            myUrlCaption[i] = myUrlCaptionMenu[i][1];
        }
        context = getApplicationContext();
        this.setTitle(name+" Headline News\n" + niceDate());
        myMainListView = (ListView) this.findViewById(R.id.myListView);
        myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> _av, View _v, int _index, long _id) {
                String urlAddress = myUrlAddress[_index], urlCaption = myUrlCaption[_index];
                Intent callShowHeadlines = new Intent(getApplicationContext(), ShowHeadlines.class);
                Bundle myData = new Bundle();
                myData.putString("urlAddress", urlAddress);
                myData.putString("urlCaption", urlCaption);
                callShowHeadlines.putExtras(myData);
                callShowHeadlines.putExtra("logo", logo);
                callShowHeadlines.putExtra("NAME",name);
                startActivity(callShowHeadlines);
            }
        });
        adapterMainSubjects = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myUrlCaption);
        myMainListView.setAdapter(adapterMainSubjects);
    }//onCreate
} // Main