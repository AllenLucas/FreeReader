package com.dawenming.freereader.Utils.Retrofit

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*
import rx.Observable

/**
 * Created by allenlucas on 17-8-29.
 */
interface ApiStores {
    companion object {
        val API_SERVER_URL = "http://47.92.115.233/web/index.php/Home/"
        const val SEARCH_URL = "Index/search"
        const val DETAILSPAGE_URL = "Index/detailspage"
        const val RECOMMEND_URL = "Index/recommend"
        const val FREQUENCY_URL = "Index/frequency"
        const val COMPETITIVELIST_URL = "Index/competitivelist"
        const val WEIRD_URL = "Index/weird"
        const val QUESTION_URL = "Index/question"
        const val IFICATION_URL = "Index/ification"
        const val BOOKLIST_URL = "Index/booklist"
        const val QUES_URL = "Index/ques"
        const val FREE_PROBATION_URL = "Index/free_probation"
        const val CAROUSEL_URL = "Index/carousel"
        const val REQUIRED_READING_URL = "Index/required_reading"
        const val SEND_SIGN_IN_URL = "User/send_sign_in"
        const val SEND_SIGN_UP_URL = "User/send_sign_up"
        const val SIGN_IN_URL = "User/sign_in"
        const val SIGN_UP_URL = "User/sign_up"
        const val PRICE_LIST_URL = "User/price_list"
        const val IS_VIP_URL = "User/is_vip"
        const val RESULT_URL = "User/result"
        const val VIP_INFO_URL = "User/vip_info"
        const val SEND_BOOK_URL = "User/send_book"
        const val MESSAGE_PROMPT_URL = "User/message_prompt"
        const val COMPLETE_IDENTIFICATION_URL = "User/complete_identification"
//        val key = "3c6e0b8a9c15224a8228b9a98ca1531d"
    }


    @GET(SEARCH_URL)
    fun getVulaeBySEARCH_URL(@Query("key") key : String
                              ,@Query("num") num :String
                              ,@Query("content") content :String) : Observable<ResponseBody>


    @POST(CAROUSEL_URL)
    fun getVulaeByCAROUSEL_URL(@Body body:RequestBody) : Observable<ResponseBody>


    @POST(IFICATION_URL)
    fun getVulaeByIFICATION_URL(@Body body:RequestBody) : Observable<ResponseBody>

    @POST(BOOKLIST_URL)
    fun getVulaeByBOOKLIST_URL(@Body body:RequestBody) : Observable<ResponseBody>
}