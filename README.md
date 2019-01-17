# NBP Api Client

### Table of content
* [General info](#general-info)
* [How to use](#how-to-use)
* [Technologies](#technologies)

### General info
NBP Api Client is a simple application for displaying currency rates. 
Thanks to it, in a simple and quick way you'll learn about exchange rates from the periods you are 
interested in.
```concept
Missing required parameter: CURRENCY_CODE
Usage: NBP api client [-c=<lastTopCount>] [-s=<date>] [-t=<table>]
                      [-d=<startStopDate> <startStopDate>]... CURRENCY_CODE...
NBP api client and currency json_converter
      CURRENCY_CODE...       Input currency or currencies to process. Use
                               three-letter currency code compliant with ISO 4217
                               standard
                             If you don't use any options to CURRENCY_CODE, you'll
                               get today's exchange rate
  -c, --last-top-count=<lastTopCount>
                             The number of recent exchange rates
  -d, --start-stop-dates=<startStopDate> <startStopDate>
                             Series of {table} exchange tables published in the date
                               range from {start-date} to {end-date} (YYYY-MM-DD =>
                               ISO 8601 standard)
  -s, --single-date=<date>   Enter the date of the currency rate (YYYY-MM-DD => ISO
                               8601 standard)
  -t, --table=<table>        Type A, B or C (buy-sell table)
```

### How to use
If you enter only EUR, the application will print today's exchange rate for that currency:
```concept
java -jar [jar file] eur
```
Application response:
```concept
NBP Api Client and currency json_converter	v1.0

EUR
Currency: EUR
Currency name: euro
011/C/NBP/2019	2019-01-16	buy: 4.2473 PLN	  sell: 4.3331 PLN	 

```

If you want to print the EUR, USD and CNY exchange rate from the last three days (counting today):
```concept
java -jar [jar file] -t a -c 3 eur usd cny
```
Application response:
```concept
NBP Api Client and currency json_converter	v1.0

EUR
Currency: EUR
Currency name: euro
009/A/NBP/2019	2019-01-14	middle: 4.2936 PLN
010/A/NBP/2019	2019-01-15	middle: 4.2922 PLN
011/A/NBP/2019	2019-01-16	middle: 4.2929 PLN

USD
Currency: USD
Currency name: dolar amerykański
009/A/NBP/2019	2019-01-14	middle: 3.7458 PLN
010/A/NBP/2019	2019-01-15	middle: 3.7542 PLN
011/A/NBP/2019	2019-01-16	middle: 3.7619 PLN

CNY
Currency: CNY
Currency name: yuan renminbi (Chiny)
009/A/NBP/2019	2019-01-14	middle: 0.5536 PLN
010/A/NBP/2019	2019-01-15	middle: 0.5556 PLN
011/A/NBP/2019	2019-01-16	middle: 0.5567 PLN
```

### Technologies
* [NBP API](http://api.nbp.pl/)
* [Gson](https://github.com/google/gson)
* [JUnitParams](https://mvnrepository.com/artifact/pl.pragmatists/JUnitParams)
* [Hamcrest](https://mvnrepository.com/artifact/org.hamcrest/hamcrest-all)
* [picocli](https://github.com/remkop/picocli)