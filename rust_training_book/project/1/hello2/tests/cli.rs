// cargo test

use assert_cmd::Command;

# [test]
// fn works() {
//   assert!(true);
//   // assert!(false);
// }

fn runs() {
  let mut cmd = Command::cargo_bin("hello2").unwrap();
  cmd.assert().success();
}
