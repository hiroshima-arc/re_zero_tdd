require 'sinatra'
require_relative './application/statement_service'
include Application

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
get '/api/text-statement' do
  service = StatementService.new

  content_type :json
  headers 'Access-Control-Allow-Origin' => '*'
  { statement: service.create_text_statement }.to_json
end

get '/api/html-statement' do
  service = StatementService.new

  content_type :json
  headers 'Access-Control-Allow-Origin' => '*'
  { statement: service.create_html_statement }.to_json
end
