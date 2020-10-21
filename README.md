# CountDownAlert
[![](https://jitpack.io/v/ochim/CountDownAlert.svg)](https://jitpack.io/#ochim/CountDownAlert)

## Getting started
Step 1. Add the JitPack repository to your build file
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}
```

Step 2. Add the dependency
```
dependencies {
    implementation 'com.github.ochim:CountDownAlert:0.2'
}
```

## Usage
```
import android.app.Dialog
import androidx.fragment.app.DialogFragment
import com.ochi.android.CountDownAlert

//reference: https://developer.android.com/guide/topics/ui/dialogs#DialogFragment
//example
class CountDownDialogFragment(val initialNumber: Int=3 , val completion: Runnable?=null) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            CountDownAlert(it).setInitialNumber(initialNumber).setCompletion({
                dismiss()
                completion?.run()
            })
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
```

## License
```
Copyright (C) 2020 ochim

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## demo
![demo](https://user-images.githubusercontent.com/7196624/95304670-f1985480-08bf-11eb-8afc-9f6054468a0b.gif)
