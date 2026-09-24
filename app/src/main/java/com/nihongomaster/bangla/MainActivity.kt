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
 Lesson("N5","日本語","にほんご","জাপানি ভাষা","Japanese language","語彙","日本語を勉強します。","にほんごを べんきょうします。","আমি জাপানি ভাষা পড়ি।"),
 Lesson("N5","大丈夫","だいじょうぶ","ঠিক আছে / সমস্যা নেই","okay / all right","会話","はい、大丈夫です。","はい、だいじょうぶです。","হ্যাঁ, ঠিক আছে।"),
 Lesson("N5","袋は要りません。","ふくろは いりません。","ব্যাগ লাগবে না।","I don't need a bag.","会話"),
 Lesson("N5","〜てもいいです","〜ても いいです","…করলেও ঠিক আছে / অনুমতি আছে","may / it is okay to","文法","ここに座ってもいいですか。","ここに すわっても いいですか。","এখানে বসতে পারি?"),
 Lesson("N4","予定","よてい","পরিকল্পনা / সময়সূচি","plan / schedule","語彙","明日の予定は何ですか。","あしたの よていは なんですか。","আগামীকালের পরিকল্পনা কী?"),
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