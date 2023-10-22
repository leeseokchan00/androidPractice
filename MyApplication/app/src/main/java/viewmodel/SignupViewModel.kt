package viewmodel

import androidx.lifecycle.ViewModel
import model.SignupData

class SignupViewModel: ViewModel() {
    var use:SignupData =SignupData("123", "asd")
}