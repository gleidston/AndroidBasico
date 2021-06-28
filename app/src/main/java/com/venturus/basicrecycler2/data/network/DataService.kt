import com.venturus.basicrecycler2.data.network.TheDataApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL="https://www.thecocktaildb.com/api/json/v1/1/"

private val retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
// objeto que inicializa a interface de metodos  ou seja onde a requisiçao vai ser feita
object DataService{
    val service: TheDataApi by lazy {
        retrofit.create(TheDataApi::class.java)
    }
}