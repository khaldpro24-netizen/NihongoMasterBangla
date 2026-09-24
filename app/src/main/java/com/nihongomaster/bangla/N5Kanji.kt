package com.nihongomaster.bangla

data class KanjiLesson(
    val kanji:String, val on:String, val kun:String, val bn:String, val en:String,
    val strokes:Int, val mnemonicBn:String, val words:String, val example:String,
    val exampleRuby:String, val exampleBn:String, val exampleEn:String
)

val n5Kanji = listOf(
 KanjiLesson("日","ニチ・ジツ","ひ・か","দিন / সূর্য","day / sun",4,"☀️ বাক্সের ভেতর সূর্য—日 মানে দিন/সূর্য।","日本（にほん） Japan ・ 日曜日（にちようび） Sunday","今日は日曜日です。","きょうは にちようびです。","আজ রবিবার।","Today is Sunday."),
 KanjiLesson("月","ゲツ・ガツ","つき","মাস / চাঁদ","month / moon",4,"🌙 বাঁকা চাঁদের আকৃতি মনে করুন—月।","月曜日（げつようび） Monday ・ 一月（いちがつ） January","月曜日に仕事があります。","げつようびに しごとが あります。","সোমবার আমার কাজ আছে।","I have work on Monday."),
 KanjiLesson("火","カ","ひ","আগুন","fire",4,"🔥 মাঝখান থেকে আগুনের শিখা ছড়াচ্ছে—火।","火曜日（かようび） Tuesday ・ 火山（かざん） volcano","火曜日に学校へ行きます。","かようびに がっこうへ いきます。","মঙ্গলবার স্কুলে যাই।","I go to school on Tuesday."),
 KanjiLesson("水","スイ","みず","পানি","water",4,"💧 মাঝের জলধারা ও দুই পাশে ছিটা—水।","水曜日（すいようび） Wednesday ・ 水（みず） water","水をください。","みずを ください。","পানি দিন।","Water, please."),
 KanjiLesson("木","モク・ボク","き","গাছ / কাঠ","tree / wood",4,"🌳 কাণ্ড, ডাল ও শিকড়সহ গাছের ছবি—木।","木曜日（もくようび） Thursday ・ 木（き） tree","大きい木があります。","おおきい きが あります。","একটি বড় গাছ আছে।","There is a big tree."),
 KanjiLesson("金","キン・コン","かね","সোনা / টাকা","gold / money",8,"✨ মাটির নিচে ঝকঝকে ধাতু/সোনা—金।","金曜日（きんようび） Friday ・ お金（おかね） money","お金がありません。","おかねが ありません。","আমার টাকা নেই।","I don't have money."),
 KanjiLesson("土","ド・ト","つち","মাটি","earth / soil",3,"🌱 মাটির ওপর একটি গাছের চারা দাঁড়িয়ে—土।","土曜日（どようび） Saturday ・ 土（つち） soil","土曜日は休みです。","どようびは やすみです。","শনিবার ছুটি।","Saturday is a day off."),
 KanjiLesson("人","ジン・ニン","ひと","মানুষ","person",2,"🚶 দুই পায়ে হাঁটা একজন মানুষ—人।","日本人（にほんじん） Japanese person ・ 一人（ひとり） one person","あの人は先生です。","あの ひとは せんせいです。","ওই ব্যক্তি শিক্ষক।","That person is a teacher."),
 KanjiLesson("山","サン","やま","পাহাড়","mountain",3,"⛰️ তিনটি পাহাড়ের চূড়া পাশাপাশি—山।","富士山（ふじさん） Mt. Fuji ・ 山（やま） mountain","山が見えます。","やまが みえます。","পাহাড় দেখা যাচ্ছে।","I can see the mountain."),
 KanjiLesson("川","セン","かわ","নদী","river",3,"🌊 তিনটি রেখায় বয়ে যাওয়া নদীর স্রোত—川।","川（かわ） river ・ 川口（かわぐち） Kawaguchi","川の近くに住んでいます。","かわの ちかくに すんでいます。","আমি নদীর কাছে থাকি।","I live near the river."),
 KanjiLesson("田","デン","た","ধানক্ষেত","rice field",5,"🌾 চার ভাগ করা ধানক্ষেত উপর থেকে দেখুন—田।","田んぼ（たんぼ） rice field ・ 田中（たなか） Tanaka","田中さんは会社員です。","たなかさんは かいしゃいんです。","তানাকা-সান একজন কোম্পানি কর্মী।","Tanaka is an office worker."),
 KanjiLesson("口","コウ・ク","くち","মুখ","mouth",3,"👄 খোলা মুখকে একটি চৌকো বাক্স ভাবুন—口।","入口（いりぐち） entrance ・ 出口（でぐち） exit","入口はあそこです。","いりぐちは あそこです。","প্রবেশপথ ওখানে।","The entrance is over there."),
 KanjiLesson("目","モク・ボク","め","চোখ","eye",5,"👁️ পাশ ঘোরানো চোখের ছবি—目।","目（め） eye ・ 目的（もくてき） purpose","目が痛いです。","めが いたいです。","আমার চোখ ব্যথা করছে।","My eye hurts."),
 KanjiLesson("耳","ジ","みみ","কান","ear",6,"👂 কানের ভেতরের রেখাগুলোসহ আকৃতি—耳।","耳（みみ） ear ・ 耳鼻科（じびか） ENT","耳が痛いです。","みみが いたいです。","আমার কান ব্যথা করছে।","My ear hurts."),
 KanjiLesson("手","シュ","て","হাত","hand",4,"✋ আঙুলসহ একটি হাত কল্পনা করুন—手।","手（て） hand ・ 上手（じょうず） skillful","手を洗ってください。","てを あらってください。","হাত ধুয়ে নিন।","Please wash your hands."),
 KanjiLesson("足","ソク","あし・た","পা / যথেষ্ট হওয়া","foot / leg / sufficient",7,"🦶 নিচে হাঁটার পা—足 দিয়ে হাঁটি।","足（あし） foot ・ 足りる（たりる） be enough","足が痛いです。","あしが いたいです。","আমার পায়ে ব্যথা।","My leg hurts."),
 KanjiLesson("上","ジョウ","うえ・あ・のぼ","উপরে / ওঠা","up / above",3,"⬆️ রেখার ওপরে দাগ—মানে উপরে, 上।","上（うえ） above ・ 上げる（あげる） raise","机の上にあります。","つくえの うえに あります。","এটি টেবিলের উপরে আছে।","It is on the desk."),
 KanjiLesson("下","カ・ゲ","した・さ・くだ","নিচে / নামা","down / below",3,"⬇️ রেখার নিচে দাগ—মানে নিচে, 下।","下（した） below ・ 下げる（さげる） lower","机の下にあります。","つくえの したに あります。","এটি টেবিলের নিচে আছে।","It is under the desk."),
 KanjiLesson("中","チュウ","なか","ভেতর / মাঝখান","inside / middle",4,"🎯 বাক্সের ঠিক মাঝ দিয়ে রেখা—中 মানে মাঝখান।","中（なか） inside ・ 中国（ちゅうごく） China","かばんの中にあります。","かばんの なかに あります。","এটি ব্যাগের ভেতরে আছে।","It is inside the bag."),
 KanjiLesson("大","ダイ・タイ","おお","বড়","big",3,"🙆 মানুষ দুই হাত বড় করে ছড়িয়েছে—大 মানে বড়।","大学（だいがく） university ・ 大きい（おおきい） big","大きい店ですね。","おおきい みせですね。","বড় দোকান, তাই না?","It's a big store, isn't it?")
)
