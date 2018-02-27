.DEFAULT_GOAL := help


.PHONY: cider
cider:
	lein repl :headless



.PHONY: help
help:
	unmake $(MAKEFILE_LIST)
