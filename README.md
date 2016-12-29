### The Issue of Multiple Files

Some apps may need to write to several files. For example a web application my write application errors to one log, and the application container may write standard Apache HTTP logs to a different file. At the moment, there seem to be two options for handling this:
- Log everything to standard out. If the log entries vary enough in format, one can differentiate the different file outputs with a series of regexs. Or simply ship the logs to destination of choice.
- The side car method. This approach spawns a "sidecar" container for each application container. This pair of conainters share a temporary volume and the application writes its logs to this location. From the point of view of the application, it is writing its logs as normail. This procedure is documented here: https://github.com/kubernetes/contrib/blob/master/logging/fluentd-sidecar-es/README.md


### The future of logging?

The sidecar approach works, though it would be nice to have this feature baked into kubernetes. From what I can tell, this PR is the epicenter for the official discussion around this topic: https://github.com/kubernetes/kubernetes/pull/13010.  This PR makes reference to this issue: https://github.com/kubernetes/kubernetes/issues/17183.

### Log testing with minikube

Kubernetes does have support for logging with fluentd/elasticsearch/kibana out of the box (this is sometimes referred to "cluster logging" in the documents). Logging is considered an "addon" and namespaced under system (for more info see https://github.com/kubernetes/kubernetes/tree/master/cluster/addons). Unfortunately minikube does not mirror this setup, so you want to experiment with logging you must emulate what a full blown k8 cluster does. Note that there is an issue open for this: https://github.com/kubernetes/minikube/issues/432 . I had originally run across this issue https://github.com/kubernetes/minikube/issues/339 but it is a dupe of https://github.com/kubernetes/minikube/issues/432 which is currently open. 
