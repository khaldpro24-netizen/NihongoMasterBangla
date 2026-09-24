package com.nihongomaster.bangla
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Lesson(val level:String,val jp:String,val reading:String,val bn:String,val en:String,val type:String)
val lessons=listOf(
 Lesson("N5","食べる","たべる","খাওয়া","to eat","語彙"),
 Lesson("N5","日本語","にほんご","জাপানি ভাষা","Japanese language","語彙"),
 Lesson("N5","〜てもいいです","〜ても いいです","…করলেও ঠিক আছে / অনুমতি আছে","may / it is okay to","文法"),
 Lesson("N5","袋は要りません。","ふくろは いりません。","ব্যাগ লাগবে না।","I don't need a bag.","会話"),
 Lesson("N4","予定","よてい","পরিকল্পনা / সময়সূচি","plan / schedule","語彙"),
 Lesson("N4","〜なければならない","〜なければ ならない","অবশ্যই করতে হবে","must / have to","文法"),
 Lesson("N3","経験","けいけん","অভিজ্ঞতা","experience","語彙"),
 Lesson("N3","〜ようにする","〜ように する","চেষ্টা/অভ্যাস করা যেন…","make an effort to","文法"),
 Lesson("N2","改善","かいぜん","উন্নতি / সংশোধন","improvement","語彙"),
 Lesson("N2","〜に違いない","〜に ちがいない","নিশ্চয়ই","must be / no doubt","文法"),
 Lesson("N1","遂行","すいこう","সম্পাদন / বাস্তবায়ন","execution","語彙"),
 Lesson("N1","〜を余儀なくされる","〜を よぎなくされる","বাধ্য হওয়া","be forced to","文法")
)
class MainActivity:ComponentActivity(){override fun onCreate(b:Bundle?){super.onCreate(b);setContent{MaterialTheme{App()}}}}
@Composable fun App(){
 var level by remember{mutableStateOf("N5")}
 Scaffold(topBar={Surface(tonalElevation=4.dp){Column(Modifier.fillMaxWidth().padding(20.dp)){Text("日本語マスター",fontSize=28.sp,fontWeight=FontWeight.Bold);Text("Nihongo Master বাংলা • JLPT N5 → N1")}}}){p->
  Column(Modifier.padding(p).padding(14.dp)){
   Text("JLPT Level",fontSize=18.sp,fontWeight=FontWeight.Bold)
   Row(Modifier.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceEvenly){listOf("N5","N4","N3","N2","N1").forEach{l->FilterChip(level==l,{level=l},{Text(l)})}}
   LazyColumn(verticalArrangement=Arrangement.spacedBy(10.dp)){items(lessons.filter{it.level==level}){x->
    Card(Modifier.fillMaxWidth(),shape=RoundedCornerShape(18.dp)){Column(Modifier.padding(18.dp)){Text(x.type+" • "+x.level);Text(x.jp,fontSize=26.sp,fontWeight=FontWeight.Bold);Text("ふりがな："+x.reading,color=MaterialTheme.colorScheme.primary);Spacer(Modifier.height(8.dp));Text("🇧🇩 "+x.bn,fontSize=17.sp);Text("🇬🇧 "+x.en,fontSize=16.sp)}}
   }}
  }
 }
}