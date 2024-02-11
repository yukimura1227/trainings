use assert_cmd::Command;
use predicates::prelude::*;
use std::fs;

type TestResult = Result<(), Box<dyn std::error::Error>>;

fn run(args: &[&str], expected_file: &str) -> TestResult {
  let expected = fs::read_to_string(expected_file)?;
  Command::cargo_bin("recho")?
    .args(args)
    .assert()
    .success()
    .stdout(expected);
  Ok(())
}

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
  run(&["Hello there"], "tests/expected/hello1.txt")
}

#[test]
fn hello2() -> TestResult {
  run(&["Hello", "there"], "tests/expected/hello2.txt")
}