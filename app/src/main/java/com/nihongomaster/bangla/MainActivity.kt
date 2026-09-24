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