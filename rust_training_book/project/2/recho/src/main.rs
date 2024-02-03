use clap::{App, Arg};

fn main() {
  let matches = App::new("recho")
    .version("0.1.0")
    .author("yukimura1227")
    .about("echo command implemented by Rust")
    .arg(
      Arg::with_name("text")
        .value_name("TEXT")
        .help("input text")
        .required(true)
        .min_values(1),
    )
    .arg(
      Arg::with_name("omit_newline")
        .short("n")
        .help("Do not print newline")
        .takes_value(false),
    )
    .get_matches();

  println!("{:#?}", matches);
}
