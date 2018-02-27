.DEFAULT_GOAL := help


.PHONY: cider
cider:
	lein repl :headless


.PHONY: build
build:
	lein uberjar


.PHONY: run
run:
	lein run


.PHONY: help
help:
	unmake $(MAKEFILE_LIST)
