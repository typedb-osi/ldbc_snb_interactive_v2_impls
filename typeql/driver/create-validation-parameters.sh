#!/usr/bin/env bash

set -eu
set -o pipefail

cd "$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
cd ..

CREATE_VALIDATION_PARAMETERS_PROPERTIES_FILE=${1:-driver/create-validation-parameters-sf0.1.properties}

java -cp target/typeql-2.0.0-SNAPSHOT.jar org.ldbcouncil.snb.driver.Client -P ${CREATE_VALIDATION_PARAMETERS_PROPERTIES_FILE}
