require 'sinatra'

before do
  if !request.body.read.empty? && !request.body.empty?
    request.body.rewind
    @params = Sinatra::IndifferentHash.new
    @params.merge!(JSON.parse(request.body.read))
  end
end

##################################
# Return a Hello world JSON
##################################
get '/api/hello-world' do
  content_type :json
  headers 'Access-Control-Allow-Origin' => '*'

  content_type :json
  { Output: 'Hello World!' }.to_json
end

post '/api/hello-world' do
  content_type :json
  headers 'Access-Control-Allow-Origin' => '*'

  content_type :json
  { Output: 'Hello World!' }.to_json
end
