package o.mysin.simbirsoftappjava.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import o.mysin.simbirsoftappjava.data.Friend
import o.mysin.simbirsoftappjava.data.User

class ProfileViewModel(
    private val liveDataForViewToObserve: MutableLiveData<User> = MutableLiveData(),
) : ViewModel() {

    fun getData(): LiveData<User> {
        return liveDataForViewToObserve
    }

    init {
        val friendList = mutableListOf<Friend>(
            Friend(name = "Николай Басков"),
            Friend(name = "Иван Петрович"),
            Friend(name = "Юлия Пересильд"),
            Friend(name = "Никос Сафронов"),
            Friend(name = "Владимир Кажома"),
            Friend(name = "Игорь Николаев"),
            Friend(name = "Алексей Гладков"),
            Friend(name = "Филлип Киркоров"),
            Friend(name = "Надежда Бабкина"),
            Friend(name = "Наруто Узумаки"),
            Friend(name = "Николай Басков"),
            Friend(name = "Иван Петрович"),
            Friend(name = "Юлия Пересильд"),
            Friend(name = "Никос Сафронов"),
            Friend(name = "Владимир Кажома"),
            Friend(name = "Игорь Николаев"),
            Friend(name = "Алексей Гладков"),
            Friend(name = "Филлип Киркоров"),
            Friend(name = "Надежда Бабкина"),
            Friend(name = "Наруто Узумаки")
        )

        val user = User(friendsList = friendList)

        liveDataForViewToObserve.value = user
    }
}