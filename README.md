# RellDatePicker
##### 커스텀 데이트 피커 다이얼로그 팝업을 만들어보았다.
##### 원래는 확인 취소 버튼 없이 날짜를 선택하면 바로 선택된 값이 콜백으로 전달되게 하려는 의도였는데
##### 버전에 따라서 그와같은 구조가 이상행동을 할 수 있는걸 발견하고
##### 그냥 확인과 취소버튼을 구현해서 만들게되었다.
##### 빌더패턴으로 구현하였으며 보다 간단하게 데이트 피커를 사용하자는 취지로 만들었다.

### 사용법
##### JITPACK을 통해 이용할 수 있으며 JITPACK을 이용하기 위해
##### 프로젝트 build.gradle에서 아래와같이 저장소의 주소를 추가해주어야한다.
##### 기본적으로 프로젝트를 생성할때는 jcenter()가 적혀있다. 

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
##### 그리고 app.gradle의 dependencies 안에다가 아래와같이 그래들의 주소를 넣어주면 된다.
##### compile 'com.github.karrel84:RellDatePicker:0.0.1'
##### 이용방법은 아래와 같다.
##### RellDatePicker picker = new RellDatePicker.Builder(MainActivity.this)
#####         .setDate(Calendar.getInstance())
#####         .create();

##### picker.show(getSupportFragmentManager(), new RellDatePicker.OnDatePickListener() {
#####     @Override
#####     public void onDatePick(Calendar calendar) {
#####         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
#####         userPicker.setText(format.format(calendar.getTime()));
#####     }
##### });
