package com.nihongomaster.bangla

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

data class Lesson(val level:String,val base:String,val ruby:String,val bn:String,val en:String,val type:String,val example:String="",val exampleRuby:String="",val exampleBn:String="")
val lessons=listOf(
 Lesson("N5","食べる","たべる","খাওয়া","to eat","語彙","ご飯を食べます。","ごはんを たべます。","আমি ভাত খাই।"),
 Lesson("N5","飲む","のむ","পান করা","to drink","語彙","水を飲みます。","みずを のみます。","আমি পানি পান করি।"),
 Lesson("N5","見る","みる","দেখা","to see / watch","語彙","テレビを見ます。","テレビを みます。","আমি টিভি দেখি।"),
 Lesson("N5","聞く","きく","শোনা / জিজ্ঞেস করা","to listen / ask","語彙","音楽を聞きます。","おんがくを ききます。","আমি গান শুনি।"),
 Lesson("N5","話す","はなす","কথা বলা","to speak","語彙","日本語で話します。","にほんごで はなします。","আমি জাপানিতে কথা বলি।"),
 Lesson("N5","読む","よむ","পড়া","to read","語彙","本を読みます。","ほんを よみます。","আমি বই পড়ি।"),
 Lesson("N5","書く","かく","লেখা","to write","語彙","名前を書きます。","なまえを かきます。","আমি নাম লিখি।"),
 Lesson("N5","買う","かう","কেনা","to buy","語彙","パンを買います。","パンを かいます。","আমি পাউরুটি কিনি।"),
 Lesson("N5","行く","いく","যাওয়া","to go","語彙","学校へ行きます。","がっこうへ いきます。","আমি স্কুলে যাই।"),
 Lesson("N5","来る","くる","আসা","to come","語彙","友達が来ます。","ともだちが きます。","বন্ধু আসবে।"),
 Lesson("N5","帰る","かえる","ফিরে যাওয়া","to return","語彙","家に帰ります。","いえに かえります。","আমি বাড়ি ফিরি।"),
 Lesson("N5","働く","はたらく","কাজ করা","to work","語彙","コンビニで働きます。","コンビニで はたらきます。","আমি কনভিনিতে কাজ করি।"),
 Lesson("N5","休む","やすむ","বিশ্রাম নেওয়া / ছুটি নেওয়া","to rest / take off","語彙","今日は休みます。","きょうは やすみます。","আজ আমি ছুটি নেব।"),
 Lesson("N5","時間","じかん","সময়","time","語彙","時間があります。","じかんが あります。","সময় আছে।"),
 Lesson("N5","今日","きょう","আজ","today","語彙","今日は忙しいです。","きょうは いそがしいです。","আজ ব্যস্ত।"),
 Lesson("N5","明日","あした","আগামীকাল","tomorrow","語彙","明日行きます。","あした いきます。","আগামীকাল যাব।"),
 Lesson("N5","昨日","きのう","গতকাল","yesterday","語彙","昨日休みました。","きのう やすみました。","গতকাল ছুটি নিয়েছিলাম।"),
 Lesson("N5","店","みせ","দোকান","shop / store","語彙","店は九時に開きます。","みせは くじに あきます。","দোকান নয়টায় খোলে।"),
 Lesson("N5","駅","えき","স্টেশন","station","語彙","駅はどこですか。","えきは どこですか。","স্টেশন কোথায়?"),
 Lesson("N5","電車","でんしゃ","ট্রেন","train","語彙","電車で行きます。","でんしゃで いきます。","আমি ট্রেনে যাই।"),
 Lesson("N5","仕事","しごと","কাজ / চাকরি","work / job","語彙","仕事が終わりました。","しごとが おわりました。","কাজ শেষ হয়েছে।"),
 Lesson("N5","お金","おかね","টাকা","money","語彙","お金を払います。","おかねを はらいます。","আমি টাকা পরিশোধ করি।"),
 Lesson("N5","入口","いりぐち","প্রবেশপথ","entrance","語彙","入口はこちらです。","いりぐちは こちらです。","প্রবেশপথ এদিকে।"),
 Lesson("N5","出口","でぐち","বের হওয়ার পথ","exit","語彙","出口は右です。","でぐちは みぎです。","বের হওয়ার পথ ডানদিকে।"),
 Lesson("N5","少し","すこし","অল্প / একটু","a little","語彙","少し待ってください。","すこし まってください。","একটু অপেক্ষা করুন।"),
 Lesson("N5","分かる","わかる","বোঝা","to understand","語彙","日本語が少し分かります。","にほんごが すこし わかります。","আমি অল্প জাপানি বুঝি।"),
 Lesson("N5","会う","あう","দেখা/সাক্ষাৎ করা","to meet","語彙","駅で友達に会います。","えきで ともだちに あいます。","স্টেশনে বন্ধুর সঙ্গে দেখা করি।"),
 Lesson("N5","待つ","まつ","অপেক্ষা করা","to wait","語彙","ここで待ってください。","ここで まってください。","এখানে অপেক্ষা করুন।"),
 Lesson("N5","使う","つかう","ব্যবহার করা","to use","語彙","カードを使います。","カードを つかいます。","কার্ড ব্যবহার করি।"),
 Lesson("N5","作る","つくる","তৈরি করা","to make","語彙","料理を作ります。","りょうりを つくります。","খাবার তৈরি করি।"),
 Lesson("N5","開ける","あける","খোলা","to open","語彙","ドアを開けます。","ドアを あけます。","দরজা খুলি।"),
 Lesson("N5","閉める","しめる","বন্ধ করা","to close","語彙","ドアを閉めます。","ドアを しめます。","দরজা বন্ধ করি।"),
 Lesson("N5","入る","はいる","প্রবেশ করা","to enter","語彙","店に入ります。","みせに はいります。","দোকানে ঢুকি।"),
 Lesson("N5","出る","でる","বের হওয়া","to leave / exit","語彙","家を出ます。","いえを でます。","বাড়ি থেকে বের হই।"),
 Lesson("N5","乗る","のる","যানে ওঠা","to ride","語彙","電車に乗ります。","でんしゃに のります。","ট্রেনে উঠি।"),
 Lesson("N5","降りる","おりる","যান থেকে নামা","to get off","語彙","次の駅で降ります。","つぎの えきで おります。","পরের স্টেশনে নামি।"),
 Lesson("N5","右","みぎ","ডান","right","語彙","右に曲がってください。","みぎに まがってください。","ডানে ঘুরুন।"),
 Lesson("N5","左","ひだり","বাম","left","語彙","左にあります。","ひだりに あります。","বাম দিকে আছে।"),
 Lesson("N5","前","まえ","সামনে / আগে","front / before","語彙","駅の前です。","えきの まえです。","স্টেশনের সামনে।"),
 Lesson("N5","後ろ","うしろ","পেছনে","behind","語彙","店の後ろです。","みせの うしろです。","দোকানের পেছনে।"),
 Lesson("N5","近い","ちかい","কাছে","near","語彙","駅は近いです。","えきは ちかいです。","স্টেশন কাছে।"),
 Lesson("N5","遠い","とおい","দূরে","far","語彙","学校は遠いです。","がっこうは とおいです。","স্কুল দূরে।"),
 Lesson("N5","高い","たかい","দামি / উঁচু","expensive / high","語彙","これは少し高いです。","これは すこし たかいです。","এটা একটু দামি।"),
 Lesson("N5","安い","やすい","সস্তা","cheap","語彙","この店は安いです。","この みせは やすいです。","এই দোকান সস্তা।"),
 Lesson("N5","新しい","あたらしい","নতুন","new","語彙","新しい仕事です。","あたらしい しごとです。","এটা নতুন কাজ।"),
 Lesson("N5","古い","ふるい","পুরোনো","old","語彙","古い建物です。","ふるい たてものです。","এটা পুরোনো ভবন।"),
 Lesson("N5","忙しい","いそがしい","ব্যস্ত","busy","語彙","今日は忙しいです。","きょうは いそがしいです。","আজ ব্যস্ত।"),
 Lesson("N5","難しい","むずかしい","কঠিন","difficult","語彙","この漢字は難しいです。","この かんじは むずかしいです。","এই কাঞ্জি কঠিন।"),
 Lesson("N5","簡単","かんたん","সহজ","easy / simple","語彙","これは簡単です。","これは かんたんです。","এটা সহজ।"),
 Lesson("N5","病院","びょういん","হাসপাতাল","hospital","語彙","病院へ行きます。","びょういんへ いきます。","হাসপাতালে যাই।"),
 Lesson("N5","銀行","ぎんこう","ব্যাংক","bank","語彙","銀行でお金を出します。","ぎんこうで おかねを だします。","ব্যাংক থেকে টাকা তুলি।"),
 Lesson("N5","会社","かいしゃ","কোম্পানি","company","語彙","会社で働いています。","かいしゃで はたらいています。","কোম্পানিতে কাজ করি।"),
 Lesson("N5","電話","でんわ","টেলিফোন / ফোন","telephone","語彙","後で電話します。","あとで でんわします。","পরে ফোন করব।"),
 Lesson("N5","名前","なまえ","নাম","name","語彙","名前を教えてください。","なまえを おしえてください。","নাম বলুন।"),
 Lesson("N5","住所","じゅうしょ","ঠিকানা","address","語彙","住所はどこですか。","じゅうしょは どこですか。","ঠিকানা কোথায়?"),
 Lesson("N5","何時","なんじ","কয়টা বাজে","what time","語彙","今、何時ですか。","いま、なんじですか。","এখন কয়টা বাজে?"),
 Lesson("N5","日本語","にほんご","জাপানি ভাষা","Japanese language","語彙","日本語を勉強します。","にほんごを べんきょうします。","আমি জাপানি ভাষা পড়ি।"),
 Lesson("N5","大丈夫","だいじょうぶ","ঠিক আছে / সমস্যা নেই","okay / all right","会話","はい、大丈夫です。","はい、だいじょうぶです。","হ্যাঁ, ঠিক আছে।"),
 Lesson("N5","袋は要りません。","ふくろは いりません。","ব্যাগ লাগবে না।","I don't need a bag.","会話"),
 Lesson("N5","〜てもいいです","〜ても いいです","…করলেও ঠিক আছে / অনুমতি আছে","may / it is okay to","文法","ここに座ってもいいですか。","ここに すわっても いいですか。","এখানে বসতে পারি?"),
 Lesson("N4","予定","よてい","পরিকল্পনা / সময়সূচি","plan / schedule","語彙","明日の予定は何ですか。","あしたの よていは なんですか。","আগামীকালের পরিকল্পনা কী?"),
 Lesson("N4","必要","ひつよう","প্রয়োজনীয়","necessary","語彙","これは必要です。","これは ひつようです。","এটা প্রয়োজনীয়।"),
 Lesson("N4","準備","じゅんび","প্রস্তুতি","preparation","語彙","仕事の準備をします。","しごとの じゅんびを します。","কাজের প্রস্তুতি নিই।"),
 Lesson("N4","説明","せつめい","ব্যাখ্যা","explanation","語彙","もう一度説明してください。","もういちど せつめいして ください。","আরেকবার ব্যাখ্যা করুন।"),
 Lesson("N4","連絡","れんらく","যোগাযোগ / খবর দেওয়া","contact","語彙","後で連絡します。","あとで れんらくします。","পরে যোগাযোগ করব।"),
 Lesson("N4","間に合う","まにあう","সময়মতো পৌঁছানো","be in time","語彙","仕事に間に合いました。","しごとに まにあいました。","কাজে সময়মতো পৌঁছেছি।"),
 Lesson("N4","遅れる","おくれる","দেরি হওয়া","be late","語彙","電車が遅れています。","でんしゃが おくれています。","ট্রেন দেরি করছে।"),
 Lesson("N4","続ける","つづける","চালিয়ে যাওয়া","continue","語彙","勉強を続けます。","べんきょうを つづけます。","পড়াশোনা চালিয়ে যাব।"),
 Lesson("N4","決める","きめる","সিদ্ধান্ত নেওয়া","decide","語彙","時間を決めます。","じかんを きめます。","সময় ঠিক করি।"),
 Lesson("N4","予約","よやく","রিজার্ভেশন / বুকিং","reservation","語彙","病院を予約しました。","びょういんを よやくしました。","হাসপাতালের অ্যাপয়েন্টমেন্ট নিয়েছি।"),
 Lesson("N4","受付","うけつけ","রিসেপশন / গ্রহণ ডেস্ক","reception","語彙","受付で聞いてください。","うけつけで きいてください。","রিসেপশনে জিজ্ঞেস করুন।"),
 Lesson("N4","住所","じゅうしょ","ঠিকানা","address","語彙","住所を書いてください。","じゅうしょを かいてください。","ঠিকানা লিখুন।"),
 Lesson("N4","給料","きゅうりょう","বেতন","salary","語彙","給料日は金曜日です。","きゅうりょうびは きんようびです。","বেতন দেওয়ার দিন শুক্রবার।"),
 Lesson("N4","確認","かくにん","নিশ্চিত/যাচাই করা","confirmation / check","語彙","内容を確認します。","ないようを かくにんします。","বিষয়টি যাচাই করি।"),
 Lesson("N4","変更","へんこう","পরিবর্তন","change","語彙","時間を変更できますか。","じかんを へんこうできますか。","সময় পরিবর্তন করা যাবে?"),
 Lesson("N4","利用","りよう","ব্যবহার","use","語彙","このカードを利用できます。","このカードを りようできます。","এই কার্ড ব্যবহার করা যাবে।"),
 Lesson("N3","状況","じょうきょう","পরিস্থিতি","situation","語彙","状況を確認します。","じょうきょうを かくにんします。","পরিস্থিতি যাচাই করছি।"),
 Lesson("N3","対応","たいおう","ব্যবস্থা নেওয়া / মোকাবিলা","response / handling","語彙","すぐに対応します。","すぐに たいおうします。","সঙ্গে সঙ্গে ব্যবস্থা নেব।"),
 Lesson("N3","判断","はんだん","সিদ্ধান্ত / বিচার","judgment","語彙","自分で判断します。","じぶんで はんだんします。","নিজে সিদ্ধান্ত নেব।"),
 Lesson("N3","原因","げんいん","কারণ","cause","語彙","原因を調べます。","げんいんを しらべます。","কারণ খুঁজে দেখব।"),
 Lesson("N3","結果","けっか","ফলাফল","result","語彙","結果を待っています。","けっかを まっています。","ফলাফলের অপেক্ষা করছি।"),
 Lesson("N3","申請","しんせい","আবেদন","application","語彙","市役所で申請します。","しやくしょで しんせいします。","সিটি অফিসে আবেদন করব।"),
 Lesson("N3","提出","ていしゅつ","জমা দেওয়া","submission","語彙","書類を提出しました。","しょるいを ていしゅつしました。","কাগজপত্র জমা দিয়েছি।"),
 Lesson("N3","勤務","きんむ","কর্মরত থাকা / ডিউটি","work duty","語彙","東京で勤務しています。","とうきょうで きんむしています。","টোকিওতে কর্মরত আছি।"),
 Lesson("N2","手続き","てつづき","প্রক্রিয়া / আনুষ্ঠানিকতা","procedure","語彙","手続きを進めます。","てつづきを すすめます。","প্রক্রিয়াটি এগিয়ে নেব।"),
 Lesson("N2","適切","てきせつ","উপযুক্ত","appropriate","語彙","適切に対応します。","てきせつに たいおうします。","উপযুক্তভাবে ব্যবস্থা নেব।"),
 Lesson("N2","維持","いじ","বজায় রাখা","maintenance","語彙","品質を維持します。","ひんしつを いじします。","মান বজায় রাখব।"),
 Lesson("N2","把握","はあく","ভালোভাবে জানা/বোঝা","grasp","語彙","状況を把握しました。","じょうきょうを はあくしました。","পরিস্থিতি বুঝেছি।"),
 Lesson("N2","負担","ふたん","বোঝা / চাপ","burden","語彙","負担を減らします。","ふたんを へらします。","চাপ কমাব।"),
 Lesson("N1","方針","ほうしん","নীতিমালা / দিকনির্দেশনা","policy / course","語彙","会社の方針に従います。","かいしゃの ほうしんに したがいます。","কোম্পানির নীতি অনুসরণ করি।"),
 Lesson("N1","円滑","えんかつ","মসৃণ / নির্বিঘ্ন","smooth","語彙","業務を円滑に進めます。","ぎょうむを えんかつに すすめます。","কাজ নির্বিঘ্নে এগিয়ে নিই।"),
 Lesson("N1","配慮","はいりょ","বিবেচনা / খেয়াল","consideration","語彙","お客様に配慮します。","おきゃくさまに はいりょします。","গ্রাহকের প্রতি খেয়াল রাখি।"),
 Lesson("N1","促進","そくしん","উৎসাহিত/ত্বরান্বিত করা","promotion / acceleration","語彙","改善を促進します。","かいぜんを そくしんします。","উন্নয়ন ত্বরান্বিত করি।"),
 Lesson("N1","見解","けんかい","মতামত / দৃষ্টিভঙ্গি","view / opinion","語彙","私の見解を説明します。","わたしの けんかいを せつめいします。","আমার মতামত ব্যাখ্যা করি।"),
 Lesson("N4","〜なければならない","〜なければ ならない","অবশ্যই করতে হবে","must / have to","文法"),
 Lesson("N3","経験","けいけん","অভিজ্ঞতা","experience","語彙"),
 Lesson("N3","〜ようにする","〜ように する","চেষ্টা/অভ্যাস করা যেন…","make an effort to","文法"),
 Lesson("N2","改善","かいぜん","উন্নতি / সংশোধন","improvement","語彙"),
 Lesson("N2","〜に違いない","〜に ちがいない","নিশ্চয়ই","must be / no doubt","文法"),
 Lesson("N1","遂行","すいこう","সম্পাদন / বাস্তবায়ন","execution","語彙"),
 Lesson("N1","〜を余儀なくされる","〜を よぎなくされる","বাধ্য হওয়া","be forced to","文法")
)

class MainActivity:ComponentActivity(){
 private var tts:TextToSpeech?=null
 override fun onCreate(b:Bundle?){super.onCreate(b);tts=TextToSpeech(this){if(it==TextToSpeech.SUCCESS)tts?.language=Locale.JAPAN};setContent{MaterialTheme{App{txt->tts?.speak(txt,TextToSpeech.QUEUE_FLUSH,null,"jp")}}}}
 override fun onDestroy(){tts?.stop();tts?.shutdown();super.onDestroy()}
}

@Composable fun RubyText(base:String,ruby:String,modifier:Modifier=Modifier){
 Column(modifier,horizontalAlignment=Alignment.CenterHorizontally){
  Text(ruby,fontSize=12.sp,lineHeight=14.sp,textAlign=TextAlign.Center,color=MaterialTheme.colorScheme.primary)
  Text(base,fontSize=27.sp,lineHeight=32.sp,fontWeight=FontWeight.Bold,textAlign=TextAlign.Center)
 }
}

@Composable fun App(speak:(String)->Unit){
 var level by remember{mutableStateOf("N5")}
 var query by remember{mutableStateOf("")}
 Scaffold(topBar={Surface(tonalElevation=4.dp){Column(Modifier.fillMaxWidth().padding(horizontal=18.dp,vertical=14.dp)){Text("日本語マスター",fontSize=27.sp,fontWeight=FontWeight.Bold);Text("Nihongo Master বাংলা  •  JLPT N5 → N1",fontSize=13.sp)}}}){p->
  Column(Modifier.padding(p).padding(horizontal=14.dp)){
   Spacer(Modifier.height(12.dp))
   OutlinedTextField(query,{query=it},Modifier.fillMaxWidth(),singleLine=true,label={Text("Search • 検索")},placeholder={Text("日本語 / বাংলা / English")})
   Spacer(Modifier.height(8.dp))
   Row(Modifier.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceBetween){listOf("N5","N4","N3","N2","N1").forEach{l->FilterChip(level==l,{level=l},{Text(l)})}}
   Text("Vocabulary • Grammar • Conversation",fontSize=13.sp,color=MaterialTheme.colorScheme.onSurfaceVariant)
   Spacer(Modifier.height(8.dp))
   val shown=lessons.filter{it.level==level && (query.isBlank() || listOf(it.base,it.ruby,it.bn,it.en).any{s->s.contains(query,true)})}
   LazyColumn(verticalArrangement=Arrangement.spacedBy(10.dp),contentPadding=PaddingValues(bottom=24.dp)){items(shown){x->
    Card(Modifier.fillMaxWidth(),shape=RoundedCornerShape(18.dp)){Column(Modifier.padding(16.dp)){
     Row(Modifier.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceBetween,verticalAlignment=Alignment.CenterVertically){AssistChip(onClick={},label={Text(x.type+" • "+x.level)});TextButton(onClick={speak(x.base)}){Text("🔊 発音")}}
     RubyText(x.base,x.ruby,Modifier.fillMaxWidth())
     Spacer(Modifier.height(10.dp));Text("🇧🇩  "+x.bn,fontSize=17.sp);Text("🇬🇧  "+x.en,fontSize=15.sp)
     if(x.example.isNotBlank()){HorizontalDivider(Modifier.padding(vertical=10.dp));Text("例文 • Example",fontWeight=FontWeight.SemiBold);RubyText(x.example,x.exampleRuby,Modifier.fillMaxWidth());Text("🇧🇩  "+x.exampleBn)}
    }}
   }}
  }
 }
}