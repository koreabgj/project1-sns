package com.example.nbc_sns.util

import android.net.Uri

import com.example.nbc_sns.model.PostImages
import com.example.nbc_sns.model.UserInfo
import com.example.nbc_sns.ui.PostManager
import com.example.nbc_sns.ui.UserManager


fun insertDummyData() {
    createNewJeans()
    createIU()
    createEXO()
    createBTS()
    createMamamoo()
}

fun createNewJeans() {
    val newJeans = UserInfo(
        id = "newjeans@gmail.com",
        pw = "defaultPassWord!",
        nickName = "newjeans_official",
        thumbnail = Uri.parse("android.resource://com.example.nbc_sns/drawable/new_jeans_thumbnail"),
        introduction = "최고의 토론만을 펼치는 엉망잔칭 토론클럽입니다.\n" +
                "매년 엉망잔칭 토론회를 주최하고 있습니다.\n"
    )
    UserManager.register(newJeans)

    PostManager.addPost(
        "[엉망잔칭 토론클럽]\n" +
                "\n" +
                "닭이 먼저다 vs 달걀이 먼저다\n" +
                "여러분의 의견은 어떠신가요?\n" +
                "\n" +
                "#엉망잔칭토론클럽 #엉망잔칭토론회",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/new_jeans_sample_post_image"),
            )
        ),
        newJeans.id,
    )

    PostManager.addPost(
        "Beautiful memories in Gaujacq with CHANEL ✨\uD83C\uDF3A",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/new_jeans_first_post"),
            )
        ),
        newJeans.id,
    )

    PostManager.addPost(
        "[엉망잔칭 토론클럽]\n" +
                "\n" +
                "버니즈 클럽과 함께 했던 특별활동\uD83C\uDF1F\n" +
                "\n" +
                "#엉망잔칭토론클럽 #엉망잔칭토론회\n",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/new_jeans_second_post"),
            )
        ),
        newJeans.id,
    )


    PostManager.addPost(
        "#광고 @olens_official \n" +
                "#NewJeans #뉴진스",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/new_jeans_third_post"),
            )
        ),
        newJeans.id,
    )

    PostManager.addPost(
        "HANNI @ <Marie Claire Korea> Digital Cover\n" +
                "\n" +
                "#광고 @chaumetofficial\n" +
                "#Chaumet #쇼메 #쇼메조세핀\n" +
                "#NewJeans #뉴진스 #HANNI",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/new_jeans_fourth_post"),
            )
        ),
        newJeans.id,
    )
    PostManager.addPost(
        "#광고 @DiorBeauty #디올뷰티 #디올백스테이지\n" +
                "#디올로지글로우 #디올립글로우 #어딕트립맥시마이저\n" +
                "#NewJeans #뉴진스 #HAERIN",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/new_jeans_fifth_post"),
            )
        ),
        newJeans.id,
    )
}

fun createIU() {
    val userIU = UserInfo(
        id = "iu@musicworld.com",
        pw = "LovePoem@2023!", // Password meets the criteria: 8+ characters, includes special character and uppercase
        nickName = "iu_official",
        thumbnail = Uri.parse("android.resource://com.example.nbc_sns/drawable/iu_thumbnail"),
        introduction = "Singing the stories of the heart through every note. 🎶\n" +
                "Embark on a journey of music and emotions with me.\n"
    )
    UserManager.register(userIU)

    PostManager.addPost(
        "좋은 꿈을 꿨죠\n" +
                "헐콘 in Yokohama\uD83D\uDC9C",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/iu_post_1"),
            )
        ),
        userIU.id,
    )

    PostManager.addPost(
        "푹 잘 자고 식탁타임에 드디어 올리는\n" +
                "헐콘 in SEOUL❤\uFE0F",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/iu_post_2"),
            )
        ),
        userIU.id,
    )

    PostManager.addPost(
        "바이바이레몬\uD83C\uDF4B",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/iu_post_3"),
            )
        ),
        userIU.id,
    )

    PostManager.addPost(
        "바이바이코랄\uD83E\uDDA9",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/iu_post_4"),
            )
        ),
        userIU.id,
    )

    PostManager.addPost(
        "The Winning",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/iu_post_5"),
            )
        ),
        userIU.id,
    )
}

fun createEXO() {
    val EXO = UserInfo(
        id = "EXO@gmail.com",
        pw = "defaultPassWord!",
        nickName = "EXO_official",
        thumbnail = Uri.parse("android.resource://com.example.nbc_sns/drawable/exo_thumnail"),
        introduction = "우린 엑소다!\n" +
                "중독 되버려~\n"
    )
    UserManager.register(EXO)
    // 사용자 기본 게시물 입력
    PostManager.addPost(
        "난 으르렁~ 으르렁~ 으르렁~ 대\n" +
                "난 늑대~ 늑대~ 늑대~\n" +
                "헤헤헤",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/exo_post_image_first"),
            )
        ),
        EXO.id,
    )
    PostManager.addPost(
        "엑소 컴백 언제인지 맞춰봐~ 선물줄게요",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/exo_post_image_second"),
            )
        ),
        EXO.id,
    )
    PostManager.addPost(
        "Someone call me Doctor\n" +
                "날 붙잡고 말해줘\n" +
                "사랑은 병 중독 Overdose",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/exo_post_image_third"),
            )
        ),
        EXO.id,
    )
    PostManager.addPost(
        "exo의 뜻은 태양계 외계행성인\n" +
                "exoplanet에서 유래된것 입니다.\n" +
                "몰랐지~?",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/exo_post_image_fourth"),
            )
        ),
        EXO.id,
    )
    PostManager.addPost(
        "우리랑 같이 감자탕 먹으러갈래?\n" +
                "먹으러가자",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/exo_post_image_fifth"),
            )
        ),
        EXO.id,
    )
}
fun createBTS() {
    val BTS = UserInfo(
        id = "BTS@gmail.com",
        pw = "defaultPassWord!",
        nickName = "BTS_official",
        thumbnail = Uri.parse("android.resource://com.example.nbc_sns/drawable/bts_thumnail"),
        introduction = "이거 방탄소년단이야~ 이 강아지야~\n"
    )
    UserManager.register(BTS)
    // 사용자 기본 게시물 입력
    PostManager.addPost(
        "불타오르네~\n" +
                "Fire~~~\n" +
                "ICE~~~",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/bts_post_image_first"),
            )
        ),
        BTS.id,
    )
    PostManager.addPost(
        "bts뜻 모르는 사람없지?\n" +
                "이거 방탄소년단이야 라는 뜻이야",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/bts_post_image_second"),
            )
        ),
        BTS.id,
    )
    PostManager.addPost(
        "우리 이쁜이들 오늘 뭐해?\n" +
                "나랑 놀자",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/bts_post_image_third"),
            )
        ),
        BTS.id,
    )
    PostManager.addPost(
        "우리 노래중 134340 이라는 노래 뜻 아십니까?\n" +
                "바로 명왕성의 코드네임입니다.\n" +
                "명왕성은 이제 태양계 행성이 아닙니다.",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/bts_post_image_fourth"),
            )
        ),
        BTS.id,
    )
    PostManager.addPost(
        "월요일 화요일 수요일 목요일 금요일 토요일 일요일~\n" +
                "이노래 알아?",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/bts_post_image_fifth"),
            )
        ),
        BTS.id,
    )
}

fun createMamamoo() {
    val mamamoo = UserInfo(
        id = "mamamoo@gmail.com",
        pw = "mapassword",
        nickName = "mamamoo_official",
        thumbnail = Uri.parse("android.resource://com.example.nbc_sns/drawable/mamamoo_thumbnail"),
        introduction = "마마무 (MAMAMOO) OFFICIAL JJABSTAGRAM\n"
    )
    UserManager.register(mamamoo)
    PostManager.addPost(
        "[#문별]\n" +
                "\n" +
                "Moon Byul 1st Full Album\n" +
                "[Starlit of Muse] 앨범 발매 및 MV 공개\n" +
                "\n" +
                "우리 무무 여러분 각 음원\n" +
                "사이트에서 많은 감상과\n" +
                "사랑 그리고 응원 부탁드립니다\n" +
                "\n" +
                "Melon\n" +
                "https://kko.to/0AR_Sesm-G\n" +
                "\n" +
                "MV\n" +
                "https://youtu.be/_EWKB1lVsyI\n" +
                "\n" +
                "#마마무 #MoonByul #Starlit_of_Muse\n" +
                "#TOUCHIN_MOVIN #터친앤무빈\n" +
                "#Think_About #띵커바웃",
        PostImages(
            listOf(
                Uri.parse("android.resource://com.example.nbc_sns/drawable/mamamoo_post_image1"),
            )
        ),
        mamamoo.id,
    )
}