library(tidyr)

stocks <- data.frame(
  time = as.Date('2009-01-01') + 0:1,
  X = rnorm(2, 0, 1),
  Y = rnorm(2, 0, 2),
  Z = rnorm(2, 0, 4)
)

# wide format data -> long format data
stocks_long <- gather(stocks, key, value, -time)
head(stocks_long)


# long format data -> wide format data
stocks_wide <- spread(stocks_long, key, value)
head(stocks_wide)

