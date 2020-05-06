## K8S

```
# list all the context for prod servers
for x in $(grep cluster: $KUBECONFIG | grep prod | awk '{ print $2 } '); do echo $x; done

# check elasticsearch health
kubectl --context ibm-sysdig-prod-us-south/c0f4eda8596a47dfb4cc505e962a856c -n sysdigcloud get pods | rg elastic | awk '{print $1}' | xargs -I{} zsh -c 'echo {}; kubectl --context ibm-sysdig-prod-us-south/c0f4eda8596a47dfb4cc505e962a856c -n sysdigcloud exec -i {} -- bash -c "curl -s \$(hostname):9200/_cat/health"'

kubectl --context ibm-sysdig-prod-us-south/c0f4eda8596a47dfb4cc505e962a856c -n sysdigcloud get pods | rg elastic | awk '{print $1}' | xargs -I{} zsh -c 'echo {}; kubectl --context ibm-sysdig-prod-us-south/c0f4eda8596a47dfb4cc505e962a856c -n sysdigcloud exec -i {} -- bash -c "curl -s \$(hostname):9200/_cat/indices"'

kubectl --context ibm-sysdig-prod-us-south/c0f4eda8596a47dfb4cc505e962a856c -n sysdigcloud get pods | rg elastic | awk '{print $1}' | xargs -I{} zsh -c 'echo {}; kubectl --context ibm-sysdig-prod-us-south/c0f4eda8596a47dfb4cc505e962a856c -n sysdigcloud exec -i {} -- bash -c "curl -s \$(hostname):9200/_cat/shards"' | rg -v STARTED

$(hostname):9200/entity_timeseries_v2_20043012/_settings

```

Access MySQL 

You should follow the steps here: https://sysdig.atlassian.net/wiki/spaces/IB/pages/733381180/Getting+started

Once you have access, first get the credentials in the configmap:

```
kubectl --context ibm-sysdig-prod-us-south -n sysdigcloud get cm sysdigcloud-config -o yaml | grep mysql
```

then use kubectl to port-forward the `svc/sysdigcloud-mysql` to a local port:

```
kubectl --context ibm-sysdig-prod-us-south -n sysdigcloud port-forward svc/sysdigcloud-mysql 33066:3306
```

finally connect to `localhost:33066` from local MySQL client.

