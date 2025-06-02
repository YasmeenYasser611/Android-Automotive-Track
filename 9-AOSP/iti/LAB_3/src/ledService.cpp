#include <iostream>
#include <sys/system_properties.h>
#include "gpiohal.hpp"
#include <android/log.h>

#define LED_PIN 17
#define HIGH 1
#define LOW 0

void init(GpioHal & _gpio) 
{
	_gpio.exportGpio(LED_PIN);
	_gpio.setGpioDirection(LED_PIN, "out");
}

int main()
{
	std::cout << "Hi From Service\n";
	GpioHal gpio = GpioHal();
	char stat;

	init(gpio);	

	while (true) 
	{
		int len = __system_property_get("led_state", &stat);
		if ((len) && (stat == '1')) 
		{
			gpio.setGpioValue(LED_PIN, HIGH);
			__android_log_print(ANDROID_LOG_INFO, "TAG", "LED is HIGH, stat = %c", stat);
		}
		else 
		{
			gpio.setGpioValue(LED_PIN, LOW);
			__android_log_print(ANDROID_LOG_INFO, "TAG", "LED is LOW, stat = %c", stat);
		}
	}

	return 0;
}
