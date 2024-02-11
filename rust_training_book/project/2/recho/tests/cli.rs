use assert_cmd::Command;
use predicates::prelude::*;
use std::fs;

type TestResult = Result<(), Box<dyn std::error::Error>>;
#[test]
fn dies_no_args() -> TestResult {
  Command::cargo_bin("recho")?
    .assert()
    .failure()
    .stderr(predicate::str::contains("USAGE"));
    Ok(())
}

#[test]
fn runs() {
    let mut cmd = Command::cargo_bin("recho").unwrap();
    cmd.arg("hello").assert().success().stdout("hello\n");
}

#[test]
fn hello1() -> TestResult {
  let expected = fs::read_to_string("tests/expected/hello1.txt")?;
  let mut cmd = Command::cargo_bin("recho").unwrap();
  cmd.arg("Hello there").assert().success().stdout(expected);
  Ok(())
}